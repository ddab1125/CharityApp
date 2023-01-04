package pl.coderslab.charity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.category.converter.CategoryConverter;
import pl.coderslab.charity.institution.converter.InstitutionConverter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        return bean;
    }
    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new CategoryConverter());
        converters.add(new InstitutionConverter());

        return converters;
    }
}
