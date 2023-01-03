package pl.coderslab.charity.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.service.DonationService;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @ModelAttribute("donationQuantity")
    public Integer getDonationQuantity() {
        return donationService.getAllDonationsQuantity();
    }

    @ModelAttribute("totalDonations")
    public Integer getTotalDonations() {
        return donationService.getTotalDonations();
    }



    @RequestMapping("/")
    public String homeAction(Model model){
    model.addAttribute("institutionList", institutionService.findAll());

        return "index";
    }
}
