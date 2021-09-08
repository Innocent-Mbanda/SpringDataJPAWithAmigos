package SpringProject1.SpringDataJPAWithAmigos.Student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.List;

@Document

public class Student {
    @Id
    private String id;
    private String FirstName;
    private String LastName;
    @Indexed(unique = true)
    private String email;
    private LocalDate dob;
    private Gender gender;
    private Address address;
    private List<String> favouriteBooks;
    private BigDecimal totalSpentOnBooks;
    private LocalDateTime created;
    @Transient

    private Integer age;


    public Student(String FirstName, String LastName, String email,
                   LocalDate dob, Gender gender, Address address,
                   List<String> favouriteBooks,
                   BigDecimal totalSpentOnBooks, LocalDateTime created) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.favouriteBooks = favouriteBooks;
        this.totalSpentOnBooks = totalSpentOnBooks;
        this.created = created;

    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getFavouriteBooks() {
        return favouriteBooks;
    }

    public void setFavouriteBooks(List<String> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public BigDecimal getTotalSpentOnBooks() {
        return totalSpentOnBooks;
    }

    public void setTotalSpentOnBooks(BigDecimal totalSpentOnBooks) {
        this.totalSpentOnBooks = totalSpentOnBooks;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", address=" + address +
                ", favouriteBooks=" + favouriteBooks +
                ", totalSpentOnBooks=" + totalSpentOnBooks +
                ", created=" + created +
                ", age=" + age +
                '}';
    }
}
