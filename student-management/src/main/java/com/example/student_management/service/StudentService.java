package com.example.student_management.service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    //contient les méthodes
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public Collection<Object[]> countByYear() {
        return studentRepository.findNbrStudentByYear();
    }

    //ajoutée
    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }


    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

}



//@controller dans spring rest mvc = pages web
//sinon @restcontroller = json