package pl.coderslab.charity.category.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.category.service.CategoryService;

@Component
public class CategoryConverter implements Converter<String, Category> {

private CategoryService categoryService;
    @Override
    public Category convert(String source) {
        return categoryService.findCategoryById(Long.valueOf(source));
    }
}
