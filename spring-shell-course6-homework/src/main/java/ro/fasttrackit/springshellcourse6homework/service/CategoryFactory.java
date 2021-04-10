package ro.fasttrackit.springshellcourse6homework.service;

import org.springframework.stereotype.Component;
import ro.fasttrackit.springshellcourse6homework.model.Category;

import java.util.Locale;

@Component
public class CategoryFactory implements CustomFactory<Category> {
    @Override
    public Category getFromString(String categoryName) {
        try{
            return Category.valueOf(categoryName.toUpperCase(Locale.ROOT));
        }catch (Exception e){
            throw new RuntimeException("Invalid category");
        }
    }
}
