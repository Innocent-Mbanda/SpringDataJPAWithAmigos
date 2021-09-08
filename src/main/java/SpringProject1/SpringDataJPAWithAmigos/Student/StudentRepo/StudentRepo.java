package SpringProject1.SpringDataJPAWithAmigos.Student.StudentRepo;

import SpringProject1.SpringDataJPAWithAmigos.Student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

}
