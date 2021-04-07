package ro.fasttrackit.springshellcourse6homework;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.springshellcourse6homework.model.Category;
import ro.fasttrackit.springshellcourse6homework.model.Product;
import ro.fasttrackit.springshellcourse6homework.service.ProductService;

import java.util.Locale;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("Print all products")
    void printAllProducts(){
        productService.getFilteredProducts(null, null)
                .forEach(System.out::println);
    }

    @ShellMethod("Print products filtered by category and/or maximum price. To omit a filter, enter null as value")
    void printFilteredProducts(String categoryString, String maxPriceString){
        productService.getFilteredProducts(categoryString.toLowerCase(Locale.ROOT).equals("null") ? null:Category.valueOf(categoryString),
                maxPriceString.toLowerCase(Locale.ROOT).equals("null") ? null:Double.parseDouble(maxPriceString))
                .forEach(System.out::println);
    }

    @ShellMethod("Get product by id")
    void getProductById(long id) {
        System.out.println(productService.getProductById(id));
    }

    @ShellMethod("Add new product. Template input: name price 'description' category")
    void addProduct(String name, double price, String description, Category category){
        System.out.println(productService.addProduct(new Product(0,name, price, description, category)));
    }

    @ShellMethod("Delete product by id")
    void deleteProductById(long id) {
        System.out.println(productService.deleteProductById(id));
    }
}
