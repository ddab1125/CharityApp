package pl.coderslab.charity.institution.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.repository.InstitutionRepository;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll() {
        return institutionRepository.findAll(Pageable.ofSize(4)).getContent();
    }

    public List<Institution> findAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution findInstitutionById(Long id) {
        return institutionRepository.findInstitutionById(id);
    }

}
