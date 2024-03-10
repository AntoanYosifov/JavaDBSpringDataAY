package com.example.json_ex.productshop.repositories;

import com.example.json_ex.productshop.entities.users.User;
import com.example.json_ex.productshop.entities.users.UserWithSoldProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u " +
            "JOIN u.sellingItems p " +
            "WHERE p.buyer IS NOT NULL")
    List<User> findAllWithSoldProducts();
}
