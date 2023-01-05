package pl.coderslab.charity.donation.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data

public class NewDonationDto {

    @Min(1)
    private int quantity;
    @NotBlank(message = "{invalid.street.not-blank}")
    private String street;
    @NotBlank(message = "{invalid.city.not-blank}")
    private String city;
    @NotBlank(message = "{invalid.zip.not-blank}")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull(message = "{invalid.pick-up-time.not-blank}")
    private LocalTime pickUpTime;
    private String pickUpComment;

    @NotEmpty(message = "{invalid.categories.not-empty}")
    private Set<Long> categories;

    @NotNull(message = "{invalid.institution.not-null}")
    private Long institution;

}
