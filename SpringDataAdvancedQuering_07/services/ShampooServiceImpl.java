package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;



@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;
    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> selectShampooBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, int labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
       return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int selectCountByPriceLessThan(double price) {
        BigDecimal bigDecimalPrice = BigDecimal.valueOf(price);
        return this.shampooRepository.countShampooByPriceLessThan(bigDecimalPrice);
    }

    @Override
    public List<Shampoo> selectIngredientsCountLessThan(int count) {
        return this.shampooRepository.findByIngredientsCountLessThan(count);
    }
}
