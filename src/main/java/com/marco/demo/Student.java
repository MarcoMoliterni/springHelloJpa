package com.marco.demo;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id()
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "STUDENT_AGE")
    private Integer age;
    @Column(name = "STUDENT_NAME")
    private String name;


}
