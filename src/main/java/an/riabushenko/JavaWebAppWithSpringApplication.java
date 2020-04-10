package an.riabushenko;

import an.riabushenko.catalog.Product;
import an.riabushenko.catalog.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class JavaWebAppWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebAppWithSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            List<Product> products = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                Product product = new Product(UUID.randomUUID(), "Product #" + i, "Product #" + i + " description");
                products.add(product);
            }
            productRepository.getProducts().addAll(products);
        };
    }
    }
