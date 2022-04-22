package com.marco.demo;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.awt.windows.ThemeReader;

import java.util.List;

import static java.lang.Thread.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@CommonsLog

public class StudentController {
    @Autowired
    private StudentRepository repo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("findAll")
    public Iterable<Student> demo(){
        log.info("simple request");

        return repo.findAll();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("age/{age}")
    public List<Student> findByName(@PathVariable Integer age){
        log.info("search by age: "+ age);
        return repo.findByAge(age);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/like/{name}")
    public List<Student> findLikename(@PathVariable String name){
        log.info("search by LIKE name: "+ name);
        int x =0;

        return repo.findLikeName(name);

    }


//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)

    public void add(@RequestBody Student s) {
        log.info("insert student: "+ s.getName()+", age: "+s.getAge() );
        repo.save(s);
    }

    @GetMapping("/lessAge/{age}")
    public List<Student> lessThenAge(@PathVariable Integer age){
      return repo.StudentLessThenAge(age);
    }

}
