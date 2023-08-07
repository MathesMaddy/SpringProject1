package com.example.SpringProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProject1.model.Model;

public interface Project1Repository extends JpaRepository<Model,Long> {
    
}
