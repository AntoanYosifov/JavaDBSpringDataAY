package com.example.json_ex.productshop.services;

import com.example.json_ex.productshop.entities.users.UserWithSoldProductDTO;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductDTO> getUsersWithSoldProducts();
}
