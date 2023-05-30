package application.controller;

import application.mapper.StudentMapper;
import application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String username, @RequestBody String password) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticated = authenticationManager.authenticate(authentication);
            return ResponseEntity.ok("Authenticated");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentMapper.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = studentMapper.findStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student) {
        studentMapper.addStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
        studentMapper.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
