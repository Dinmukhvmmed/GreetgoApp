package application.controller;

import application.mapper.StudentMapper;
import application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/")
    public ResponseEntity getAllStudents() {
        List<Student> students = studentMapper.findAllStudents();
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable int id) {
        Student student = studentMapper.findStudent(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addStudent(Student student) {
        studentMapper.addStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentMapper.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
