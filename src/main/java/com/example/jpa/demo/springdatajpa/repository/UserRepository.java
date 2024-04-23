package com.example.jpa.demo.springdatajpa.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.example.jpa.demo.springdatajpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Page<User> findByAge(int age, Pageable pageable);
}
