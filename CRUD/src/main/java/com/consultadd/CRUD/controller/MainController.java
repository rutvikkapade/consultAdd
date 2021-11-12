package com.consultadd.CRUD.controller;

import java.util.List;

import com.consultadd.CRUD.model.Student;
import com.consultadd.CRUD.repository.StudentRepo;
import com.consultadd.CRUD.requestObject.StudentMarks;
import com.consultadd.CRUD.responseObject.DeletedStudent;
import com.consultadd.CRUD.service.StudentService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Working!",HttpStatus.OK);
    }
    @PostMapping("/addStudent")
    public Student sendWelcome(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }
    
    @PutMapping("/update/{email}")
    public ResponseEntity<Student>updateMarksByEmail(@PathVariable String email,@RequestBody StudentMarks studentMarks){
    
        return new ResponseEntity<>(studentService.updateMarks(studentMarks,email),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<DeletedStudent> deleteByEmail(@PathVariable String email){
        Student student=studentService.deleteStudentRecord(email);
       
             DeletedStudent deletedStudent=new DeletedStudent(student, (student==null? "student with email "+email+" does not exist":"deleted"));
            return new ResponseEntity<>(deletedStudent,HttpStatus.OK);
    }
    
}
