package pl.coderslab.charity.institution.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.institution.entity.Institution;
import pl.coderslab.charity.institution.service.InstitutionService;

@Component
public class InstitutionConverter implements Converter<String, Institution> {

    private InstitutionService institutionService;

    @Override
    public Institution convert(String source) {
        return institutionService.findInstitutionById(Long.valueOf(source));
    }
}
