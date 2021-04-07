package ro.fasttrackit.productsappcourse6homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.productsappcourse6homework.entity.Category;
import ro.fasttrackit.productsappcourse6homework.entity.Product;
import ro.fasttrackit.productsappcourse6homework.repository.ProductsRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository repository;

    public List<Product> getAllOrFilterProducts(Category category, Double maxPrice){
        return repository.findAll()
                .stream()
                .filter(products -> category == null || products.getCategory() == category)
                .filter(products -> maxPrice == null || products.getPrice() <= maxPrice)
                .collect(toList());
    }

    public Optional<Product> getProductById(long productId){
        return repository.findById(productId);
    }

    public Product addProduct(Product newProduct){
        return repository.save(newProduct);
    }

    public void deleteProductById(long productId){
        repository.deleteById(productId);
    }
}

