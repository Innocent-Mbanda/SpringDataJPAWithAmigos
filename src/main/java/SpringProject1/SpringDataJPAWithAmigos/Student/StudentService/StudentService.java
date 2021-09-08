package SpringProject1.SpringDataJPAWithAmigos.Student.StudentService;

import SpringProject1.SpringDataJPAWithAmigos.Student.Student;
import SpringProject1.SpringDataJPAWithAmigos.Student.StudentRepo.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
@AllArgsConstructor
public class StudentService {


    private final StudentRepo studentRepo;

    //    public StudentService(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


    public void addNewStudent(Student student) {
        studentRepo.findStudentByEmail(student.getEmail()).ifPresentOrElse(s -> {
                    throw new IllegalStateException("Student exist");
                }, () -> {
                    System.out.println("insert student");

                    studentRepo.save(student);
                }


        );

    }

    public void deleteStudentById(String id) {
        boolean exists = studentRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException(" student with id = " + id + " does not exist");
        } else {
            studentRepo.deleteById(id);
        }
    }

//    @Transactional
//
//    public void updateStudent(String id, String name, String email) {
//
//        Student student = studentRepo.findAllById(id)
//                .orElseThrow(() -> new IllegalStateException("student with id  "+ id
//                "does not exist"));
//
//        if (name != null &&
//        name.length() >0 && !object.equals(student.getFirstName(),name)){
//            student.setFirstName(name);
//        }
    

}

