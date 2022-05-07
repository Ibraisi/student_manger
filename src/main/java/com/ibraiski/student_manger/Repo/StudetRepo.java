package com.ibraiski.student_manger.Repo;

import com.ibraiski.student_manger.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface StudetRepo extends JpaRepository<Student,Long> {
    @Transactional
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
