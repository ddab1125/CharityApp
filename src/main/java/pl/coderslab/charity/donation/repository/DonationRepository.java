package pl.coderslab.charity.donation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.donation.entity.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {


    @Query("SELECT sum(quantity) from Donation")
    Optional<Integer> getDonationsQuantity();

    @Query("SELECT count(*) from Donation")
    int getTotalDonations();
}
