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

    @PostMapping("/")
    public ResponseEntity addStudent(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "surname") String surname,
                                      @RequestParam(name = "age") int age,
                                      @RequestParam(name = "average grade") double averageGrade) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setAverageGrade(averageGrade);
        studentMapper.addStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteStudent(@RequestParam(name = "id") int id) {
        studentMapper.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
