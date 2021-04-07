package ro.fasttrackit.springshellcourse6homework.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.fasttrackit.springshellcourse6homework.model.Category;
import ro.fasttrackit.springshellcourse6homework.model.Product;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {

    public List<Product> getFilteredProducts(Category category, Double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8085/products")
                .queryParam("category", category)
                .queryParam("maxPrice", maxPrice);
        return restTemplate.exchange(builder.toUriString(), GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getProductById(long productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8085/products/" + productId, Product.class);
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:8085/products", newProduct, Product.class);
    }

    public String deleteProductById(long productId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8085/products/" + productId);
        return "Deleted Successfully";
    }
}
