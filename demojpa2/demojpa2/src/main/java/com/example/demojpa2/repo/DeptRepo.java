package com.example.demojpa2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa2.entity.DeptEntity;

public interface DeptRepo extends JpaRepository<DeptEntity, Integer> {

}
