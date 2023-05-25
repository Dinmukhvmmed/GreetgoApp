package application.controller;

import application.mapper.StudentMapper;
import application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/")
    private ResponseEntity getAllStudents() {
        List<Student> students = studentMapper.findAllStudents();
        return new ResponseEntity(students, HttpStatus.OK);
    }
}
