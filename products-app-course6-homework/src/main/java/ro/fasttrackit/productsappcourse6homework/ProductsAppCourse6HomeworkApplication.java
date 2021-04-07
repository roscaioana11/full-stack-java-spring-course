package ro.fasttrackit.productsappcourse6homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.productsappcourse6homework.entity.Category;
import ro.fasttrackit.productsappcourse6homework.entity.Product;
import ro.fasttrackit.productsappcourse6homework.repository.ProductsRepository;

import java.util.List;

@SpringBootApplication
public class ProductsAppCourse6HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppCourse6HomeworkApplication.class, args);
	}
/**
 * Bean-ul nu este apelat la initializarea programului si a trebuit sa fac clasa de config folosind @Component
 */
//	@Bean
//	CommandLineRunner atStartup(ProductsRepository repository) {
//		return args -> {
//			System.out.println("-----------------------------");
//			repository.saveAll(List.of(
//					new Product("Paine", 2.5, "paine alba", Category.BAKERY),
//					new Product("Lapte", 7.2, "lapte de vaca", Category.DAIRY_PRODUCTS),
//					new Product("Ciocolata", 10.0, "ciocolata neagra", Category.SWEETS),
//					new Product("Mar", 0.6, "mere de Romania", Category.FRUITS)
//			));
//		};
//	}
}
