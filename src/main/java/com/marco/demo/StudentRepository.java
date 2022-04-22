package com.marco.demo;

import com.marco.demo.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.temporal.ValueRange;
import java.util.List;

//cuore dell'app, è un iterfaccia a cui viene passata entity e tipo di chiave
//qui le CRUD sono gia impostate
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
// se uso findBy[Nome attributo dell'entity] lui automaticamente mi crea una select all dell'atributo
    List<Student> findByAge(Integer Age);



    @Query(value = "SELECT * FROM student WHERE STUDENT_NAME LIKE %:name%", nativeQuery = true)
    List<Student> findLikeName(@Param("name") String name);


}
