package com.emirzone.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class AuthServiceApplication {

    @Autowired // Köprüyü buraya bağla
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    // 1. KULLANICI EKLEME (Test Linki ile)
    @GetMapping("/ekle")
    public String ekle(@RequestParam String isim, @RequestParam String sifre) {
        User u = new User();
        u.setUsername(isim);
        u.setPassword(sifre);
        userRepository.save(u); // Veritabanına kaydet
        return "Kaydedildi: " + isim;
    }

    // 2. TÜM KULLANICILARI LİSTELEME
    @GetMapping("/listele")
    public List<User> listele() {
        return userRepository.findAll(); 
    }
}