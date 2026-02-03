package com.emirzone.auth_service;

import org.springframework.data.jpa.repository.JpaRepository;

// User tablosu ile konuşacak köprü. <User, Long> demek: User tablosu, ID'si Long türünde.
public interface UserRepository extends JpaRepository<User, Long> {
    // Buraya özel sorgular eklenebilir ama şimdilik boş kalsın.
    // Spring bizim için "save", "findAll", "delete" gibi komutları gizlice oluşturdu bile.
}