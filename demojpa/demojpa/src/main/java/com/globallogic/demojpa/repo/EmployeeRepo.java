package com.globallogic.demojpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.demojpa.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}