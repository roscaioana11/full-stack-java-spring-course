package ro.fasttrackit.productsappcourse6homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.productsappcourse6homework.entity.Category;
import ro.fasttrackit.productsappcourse6homework.entity.Product;
import ro.fasttrackit.productsappcourse6homework.exceptions.ResourceNotFoundException;
import ro.fasttrackit.productsappcourse6homework.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService service;

    @GetMapping
    List<Product> getAllOrFilterProducts(@RequestParam(required = false) Category category,
                                         @RequestParam(required = false) Double maxPrice){
        return service.getAllOrFilterProducts(category, maxPrice);
    }

    @GetMapping("{productId}")
    Product getProductById(@PathVariable long productId){
        return service.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product with id " + productId));
    }

    @PostMapping
    Product addProduct(@RequestBody Product newProduct){
        return service.addProduct(newProduct);
    }

    @DeleteMapping("{productId}")
    public void deleteProductById(@PathVariable ("productId") long productId){
        service.deleteProductById(productId);
    }
}
