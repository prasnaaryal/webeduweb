package com.example.educa.repo;

import com.example.educa.Entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
