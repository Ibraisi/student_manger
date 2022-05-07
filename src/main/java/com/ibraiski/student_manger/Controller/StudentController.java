package com.ibraiski.student_manger.Controller;

import com.ibraiski.student_manger.Service.StudetService;
import com.ibraiski.student_manger.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudetService studetService;

    @Autowired
    public StudentController(StudetService studetService) {
        this.studetService = studetService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studetService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student = studetService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studetService.addStudet(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student newStudent = studetService.updateStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }
    @DeleteMapping(value = "/d/{id}")
    public ResponseEntity<?> addStudent(@PathVariable("id") Long id){
        studetService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll(){
        studetService.deleteAllStudents();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
