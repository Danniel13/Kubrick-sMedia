package com.dani.dev.videotienda.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dani.dev.videotienda.model.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
