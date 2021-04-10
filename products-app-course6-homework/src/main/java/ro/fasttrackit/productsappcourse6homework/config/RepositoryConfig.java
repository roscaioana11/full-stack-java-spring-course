package ro.fasttrackit.productsappcourse6homework.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.productsappcourse6homework.entity.Category;
import ro.fasttrackit.productsappcourse6homework.entity.Product;
import ro.fasttrackit.productsappcourse6homework.repository.ProductsRepository;

import java.util.List;

@Component
public class RepositoryConfig implements CommandLineRunner {
    private final ProductsRepository repository;

    public RepositoryConfig(ProductsRepository repository) {
        this.repository = repository;
    }

//    public RepositoryConfig(ProductsRepository repository) {
//        atStartup(repository);
//    }

//    void atStartup(ProductsRepository repository) {
//
//            System.out.println("-------------------------------");
//            repository.saveAll(List.of(
//                    new Product("Paine", 2.5, "paine alba", Category.BAKERY),
//                    new Product("Lapte", 7.2, "lapte de vaca", Category.DAIRY_PRODUCTS),
//                    new Product("Ciocolata", 10.0, "ciocolata neagra", Category.SWEETS),
//                    new Product("Mar", 0.6, "mere de Romania", Category.FRUITS)
//            ));
//    }

    @Override
    public void run(String... args) throws Exception {
			System.out.println("-----------------------------");
			repository.saveAll(List.of(
					new Product("Paine", 2.5, "paine alba", Category.BAKERY),
					new Product("Lapte", 7.2, "lapte de vaca", Category.DAIRY_PRODUCTS),
					new Product("Ciocolata", 10.0, "ciocolata neagra", Category.SWEETS),
					new Product("Mar", 0.6, "mere de Romania", Category.FRUITS)
			));
    }
}
