package com.ecomm.EcommApp.Config;

import com.ecomm.EcommApp.Model.Category;
import com.ecomm.EcommApp.Model.Product;
import com.ecomm.EcommApp.Repository.CategoryRepository;
import com.ecomm.EcommApp.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class DataSeeder implements CommandLineRunner {

    //Get logs for this class to ensure data are loaded before we send request
    private static final Logger logger = LoggerFactory.getLogger(DataSeeder.class);
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // we want to clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create Category
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // Create Products
        Product phone = new Product();
        phone.setName("SamSung");
        phone.setDescription("Latest Model Samsung with cool features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(999.9);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Asus ZenBook");
        laptop.setDescription("Latest Model Asus with cool features");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(1099.9);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy jacket for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(99.9);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Swiss Blender");
        blender.setDescription("High-speed blender so nice");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(89.9);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));

        logger.info("DataSeeder completed successfully.");
    }
}
