package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> selectShampooBySize(Size size);
    List<Shampoo> selectBySizeOrLabelId(Size size, int labelId);
}
