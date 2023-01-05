package pl.coderslab.charity.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.category.service.CategoryService;
import pl.coderslab.charity.donation.dto.NewDonationDto;
import pl.coderslab.charity.donation.mapper.DonationMapper;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donate")
@RequiredArgsConstructor
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    private final DonationService donationService;

    private final DonationMapper mapper;


    @ModelAttribute(name = "institutions")
    public List<Institution> getAllInstitutions() {
        return institutionService.findAllInstitutions();
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
    public String saveDonationForm(@ModelAttribute("donation") @Valid NewDonationDto donation, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        donationService.saveDonation(mapper.toDonation(donation));
        return "form-confirmation";
    }
}
