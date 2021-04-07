package ro.fasttrackit.productsappcourse6homework.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public Product(String name, double price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
