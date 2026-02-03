package com.emirzone.auth_service;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // 1. Bu bir veritabanı tablosudur
@Table(name = "users") // 2. Tablonun adı 'users' olsun
@Data // 3. Lombok: Getter/Setter'ları otomatik yaz
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. ID'yi otomatik 1, 2, 3 diye artır
    private Long id;

    private String username;
    private String password; // Gerçek projede şifreler şifrelenir (Hash), şimdilik düz yazıyoruz.
}