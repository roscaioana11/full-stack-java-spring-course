package ro.fasttrackit.productsappcourse6homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.productsappcourse6homework.entity.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
