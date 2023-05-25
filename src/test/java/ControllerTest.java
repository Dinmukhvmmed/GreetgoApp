import application.MyApplication;
import application.mapper.StudentMapper;
import application.model.Student;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = MyApplication.class)
@AutoConfigureMockMvc
public class ControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentMapper studentMapper;

    private List<Student> students = new ArrayList<>();

    @BeforeClass
    public void setup() {
        studentMapper = Mockito.mock(StudentMapper.class);
        Student student1 = new Student();
        student1.setName("Вася");
        student1.setSurname("Пупкин");
        student1.setAge(10);
        student1.setAverageGrade(1.0);

        Student student2 = new Student();
        student2.setName("Альберт");
        student2.setSurname("Эйнштейн");
        student2.setAge(7);
        student2.setAverageGrade(5.0);

        students.add(student1);
        students.add(student2);
    }

    @Test
    public void testGetAllStudents() throws Exception {
        Mockito.when(studentMapper.findAllStudents()).thenReturn(students);

        mockMvc.perform(get("/").with(user("user").password("123456")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(students.size()))
                .andExpect(jsonPath("$[0].name").value("Вася"))
                .andExpect(jsonPath("$[0].surname").value("Пупкин"))
                .andExpect(jsonPath("$[0].age").value(10))
                .andExpect(jsonPath("$[1].name").value("Альберт"))
                .andExpect(jsonPath("$[1].surname").value("Эйнштейн"))
                .andExpect(jsonPath("$[1].age").value(7));
    }
}
