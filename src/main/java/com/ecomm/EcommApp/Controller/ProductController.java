package com.ecomm.EcommApp.Controller;

import com.ecomm.EcommApp.Model.Product;
import com.ecomm.EcommApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{catId}")
    public List<Product> getAllProductsByCategoryId(@PathVariable Long catId){
        return productService.getProductByCategory(catId);
    }

}
