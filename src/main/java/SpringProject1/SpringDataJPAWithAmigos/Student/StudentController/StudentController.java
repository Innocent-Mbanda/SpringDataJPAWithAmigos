package SpringProject1.SpringDataJPAWithAmigos.Student.StudentController;

import SpringProject1.SpringDataJPAWithAmigos.Student.Student;
import SpringProject1.SpringDataJPAWithAmigos.Student.StudentService.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
  public List<Student>fetchAllStudents(){
   return studentService.getAllStudents();
  }

  @PostMapping

    public void registerNewStudent( @RequestBody Student student){
        studentService.addNewStudent(student);
  }
  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable ("studentId") String id){
        studentService.deleteStudentById(id);
  }

  @PutMapping(path = "{studentId")
    public void updateStudent(@PathVariable ("StudentId") String id,
                              @RequestParam (required = false)String name,
                              @RequestParam (required = false), String email){
        studentService.updateStudent(id,name,email);
  }
    }

