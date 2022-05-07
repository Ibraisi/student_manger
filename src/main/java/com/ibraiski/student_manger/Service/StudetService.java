package com.ibraiski.student_manger.Service;

import com.ibraiski.student_manger.Exception.UserNotFoundException;
import com.ibraiski.student_manger.Repo.StudetRepo;
import com.ibraiski.student_manger.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;
@Service
public class StudetService {
    private StudetRepo studetRepo;

    @Autowired
    public StudetService(StudetRepo studetRepo) {
        this.studetRepo = studetRepo;
    }

    public Student addStudet(Student student ){
        student.setStudentCode(UUID.randomUUID().toString());
        return studetRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studetRepo.findAll();
    }
    public Student updateStudent(Student student){
        return studetRepo.save(student);
    }
    public void deleteStudentById(Long id){
        studetRepo.deleteStudentById(id);
    }
    public Student findStudentById(Long id){
        return studetRepo.findStudentById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + "was not found"));
    }
    public void deleteAllStudents(){
         studetRepo.deleteAll();
    }
}
