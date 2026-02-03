package com.emirzone.product_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SpringBootApplication
@RestController
public class ProductServiceApplication {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    // Ürün ekleme - Linke ne yazarsan o kaydolur
    @GetMapping("/ekle")
    public String ekle(@RequestParam String ad, @RequestParam Double fiyat) {
        Product p = new Product();
        p.setName(ad);
        p.setPrice(fiyat);
        productRepository.save(p);
        return "Ürün başarıyla kaydedildi: " + ad;
    }

    // Kayıtlı tüm ürünleri görme
    @GetMapping("/liste")
    public List<Product> liste() {
        return productRepository.findAll();
    }
}