package ro.fasttrackit.springshellcourse6homework;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.springshellcourse6homework.model.Category;
import ro.fasttrackit.springshellcourse6homework.model.Product;
import ro.fasttrackit.springshellcourse6homework.service.CategoryFactory;
import ro.fasttrackit.springshellcourse6homework.service.PriceFactory;
import ro.fasttrackit.springshellcourse6homework.service.ProductService;

import java.util.Locale;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;
    private final CategoryFactory categoryFactory;
    private final PriceFactory priceFactory;

    @ShellMethod("Print all products")
    void printAllProducts(){
        productService.getFilteredProducts(null, null)
                .forEach(System.out::println);
    }

    @ShellMethod("Print products filtered by category and/or maximum price. To omit a filter, enter null as value")
    void printFilteredProducts(String categoryString, String maxPriceString){
        try {
            productService.getFilteredProducts(
                    categoryFactory.getFromString(categoryString), priceFactory.getFromString(maxPriceString))
                    .forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod("Get product by id")
    void getProductById(long id) {
        try {
            System.out.println(productService.getProductById(id));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod("Add new product. Template input: name price 'description' category")
    void addProduct(String name, String priceString, String description, String categoryString){
        try {
            System.out.println(productService.addProduct(new Product(0,name,
                    priceFactory.getFromString(priceString), description, categoryFactory.getFromString(categoryString))));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @ShellMethod("Delete product by id")
    void deleteProductById(long id) {
        System.out.println(productService.deleteProductById(id));
    }
}
