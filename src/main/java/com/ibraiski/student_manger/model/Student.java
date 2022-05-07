package com.ibraiski.student_manger.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String first_name;
    private String last_name;
    private String major;
    private String email;
    private String phone;
    private String imgUrl;
    @Column(nullable = false,updatable = false)
    private String studentCode;
}
