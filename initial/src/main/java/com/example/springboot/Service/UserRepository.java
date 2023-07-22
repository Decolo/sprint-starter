package com.example.springboot.Service;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE name like %:search% OR email like %:search%", nativeQuery = true)
    ArrayList<User> getUsersBySearch(@Param("search") String search);
}
