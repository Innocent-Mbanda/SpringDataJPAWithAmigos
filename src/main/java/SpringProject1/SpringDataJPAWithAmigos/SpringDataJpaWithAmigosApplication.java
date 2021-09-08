package SpringProject1.SpringDataJPAWithAmigos;

import SpringProject1.SpringDataJPAWithAmigos.Student.Address;
import SpringProject1.SpringDataJPAWithAmigos.Student.Gender;
import SpringProject1.SpringDataJPAWithAmigos.Student.Student;
import SpringProject1.SpringDataJPAWithAmigos.Student.StudentRepo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;


@SpringBootApplication

public class SpringDataJpaWithAmigosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaWithAmigosApplication.class, args);
	}

@Bean
	CommandLineRunner runner (StudentRepo repo, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address("Rwanda","Kigali","2042 N Humpsteam ln");
			String email ="mbanda@gmail.com";

			Student Mbanda = new Student(
					"Innocent",
					"Mbanda",
				    email,
					LocalDate.of(2000,4,20),
					Gender.FEMALE,address,List.of("Computer Science","Data Science"),
					BigDecimal.TEN, LocalDateTime.now()
			);

			Student Alex = new Student(
					"Alex",
					"Mugabo",
			 email = "alex@gmail.com",
					LocalDate.of(2000,4,20),
					Gender.FEMALE,address,List.of("Computer Science","Data Science"),
					BigDecimal.TEN, LocalDateTime.now()
			);
//			usingMongoTemplateAndQuery(repo, mongoTemplate, email, s1);

			repo.findStudentByEmail(email).ifPresentOrElse( Student ->{
				System.out.println(Student + "already exists");
			},()->{
				System.out.println("Inserting s1 " );
//				repo.insert(s1);
				repo.saveAll(
						List.of(Mbanda,Alex)
				);
			});


//			repo.insert(s1);
		};
}

	private void usingMongoTemplateAndQuery(StudentRepo repo, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);
		if (students.size()>1){
			throw new IllegalStateException("found many student with " + email);

		}
		if (students.isEmpty()){
			System.out.println("Inserting student " + student);
			repo.insert(student);
		} else {
			System.out.println(student + "already exists");
		}
	}

}
