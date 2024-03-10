package com.example.json_ex.productshop.services;

import com.example.json_ex.productshop.entities.users.User;
import com.example.json_ex.productshop.entities.users.UserWithSoldProductDTO;
import com.example.json_ex.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<UserWithSoldProductDTO> getUsersWithSoldProducts() {
        List<User> allWithSoldProducts = this.userRepository.findAllWithSoldProducts();

        return allWithSoldProducts.stream()
                .map(user-> this.modelMapper.map(user, UserWithSoldProductDTO.class))
                .collect(Collectors.toList());
    }
}
