package pl.coderslab.charity.donation.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.institution.entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
@Data
public class NewDonationDto {

   private int quantity;
   private String street;
   private String city;
   private String zipCode;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate pickUpDate;
   private LocalTime pickUpTime;
   private String pickUpComment;
   private Set<Long> categories;
   private long institution;

}
