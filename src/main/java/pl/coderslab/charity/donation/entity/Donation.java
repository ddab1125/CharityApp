package pl.coderslab.charity.donation.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.institution.entity.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    @ManyToMany
    private Set<Category> categories;

    @ManyToOne
    private Institution institution;

}
