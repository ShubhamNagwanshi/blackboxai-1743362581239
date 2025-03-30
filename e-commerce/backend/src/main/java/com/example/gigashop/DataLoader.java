package com.example.gigashop;

import com.example.gigashop.model.Product;
import com.example.gigashop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        productRepository.deleteAll();

        // Sample electronics
        productRepository.save(new Product(null, "Smartphone", "Latest model with 128GB storage", 699.99, "Electronics", "https://images.pexels.com/photos/788946/pexels-photo-788946.jpeg"));
        productRepository.save(new Product(null, "Laptop", "16GB RAM, 1TB SSD", 1299.99, "Electronics", "https://images.pexels.com/photos/18105/pexels-photo.jpg"));
        
        // Sample clothing
        productRepository.save(new Product(null, "T-Shirt", "Cotton crew neck", 24.99, "Clothing", "https://images.pexels.com/photos/2294342/pexels-photo-2294342.jpeg"));
        productRepository.save(new Product(null, "Jeans", "Slim fit denim", 59.99, "Clothing", "https://images.pexels.com/photos/1598507/pexels-photo-1598507.jpeg"));
        
        // Sample home goods
        productRepository.save(new Product(null, "Coffee Maker", "Programmable 12-cup", 49.99, "Home", "https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg"));
        
        System.out.println("Sample products loaded successfully!");
    }
}