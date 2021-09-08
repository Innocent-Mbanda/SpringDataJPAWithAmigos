//package SpringProject1.SpringDataJPAWithAmigos.Student.StudentConfig;
//
//import SpringProject1.SpringDataJPAWithAmigos.Student.Address;
//import SpringProject1.SpringDataJPAWithAmigos.Student.Gender;
//import SpringProject1.SpringDataJPAWithAmigos.Student.Student;
//import SpringProject1.SpringDataJPAWithAmigos.Student.StudentRepo.StudentRepo;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//@Bean
//    CommandLineRunner commandLineRunner (StudentRepo  studentRepo){
//    return args -> {
//        Address address = new Address("Rwanda","Kigali","2042 N Humpsteam ln");
//        String email ="mbanda@gmail.com";
//
//        Student Mbanda = new Student(
//                "Innocent",
//                "Mbanda",
//                email,
//                LocalDate.of(2000,4,20),
//                Gender.FEMALE,address, List.of("Computer Science","Data Science"),
//                BigDecimal.TEN, LocalDateTime.now()
//        );
//
//        Student Alex = new Student(
//                "Alex",
//                "Mugabo",
//                email,
//                LocalDate.of(2000,4,20),
//                Gender.FEMALE,address, List.of("Computer Science","Data Science"),
//                BigDecimal.TEN, LocalDateTime.now()
//        );
//
//        studentRepo.saveAll(
//                List.of(Mbanda,Alex)
//        );
//    };
//
//    }
//}
