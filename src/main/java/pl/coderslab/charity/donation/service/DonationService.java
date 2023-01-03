package pl.coderslab.charity.donation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.entity.Donation;
import pl.coderslab.charity.donation.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Integer getAllDonationsQuantity() {
        return donationRepository.getDonationsQuantity().orElse(0);

    }

    public int getTotalDonations() {
        return donationRepository.getTotalDonations();
    }

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

}
