package com.example.demojpa2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa2.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}