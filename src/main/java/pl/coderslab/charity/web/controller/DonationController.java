package pl.coderslab.charity.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.dto.NewDonationDto;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.repository.DonationRepository;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/donate")
@RequiredArgsConstructor
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    private final DonationService donationService;

    @ModelAttribute(name = "institutions")
    public List<Institution> getAllInstitutions() {
        return institutionService.findAll();
    }

    @ModelAttribute(name = "categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }


    @GetMapping("/new")
    public String donationForm(Model model) {
        model.addAttribute("donation", new NewDonationDto());

        return "form";
    }

    @PostMapping("/new")
    public String saveDonationForm(Donation donation) {
        donationService.saveDonation(donation);
        System.out.println(donation);
        return "form-confirmation";
    }
}
