package application.mapper;

import application.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    void addStudent(Student student);
    void deleteStudent(Integer id);
    List<Student> findAllStudents();
}
