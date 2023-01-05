package pl.coderslab.charity.donation.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.dto.NewDonationDto;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.institution.service.InstitutionService;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DonationMapper {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    public Donation toDonation(NewDonationDto newDonationDto) {
        Donation donation = new Donation();
        donation.setQuantity(newDonationDto.getQuantity());
        donation.setStreet(newDonationDto.getStreet());
        donation.setCity(newDonationDto.getCity());
        donation.setZipCode(newDonationDto.getZipCode());
        donation.setPickUpDate(newDonationDto.getPickUpDate());
        donation.setPickUpTime(newDonationDto.getPickUpTime());
        donation.setPickUpComment(newDonationDto.getPickUpComment());
        donation.setPhoneNumber(newDonationDto.getPhoneNumber());
        donation.setCategories(newDonationDto.getCategories().stream().map(c -> categoryService.findCategoryById(c)).collect(Collectors.toSet()));
        donation.setInstitution(institutionService.findInstitutionById(newDonationDto.getInstitution()));

        return donation;
    }
}
