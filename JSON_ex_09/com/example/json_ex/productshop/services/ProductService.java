package com.example.json_ex.productshop.services;

import com.example.json_ex.productshop.entities.categories.CategoryStats;
import com.example.json_ex.productshop.entities.products.Product;
import com.example.json_ex.productshop.entities.products.ProductWithoutBuyerDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(
            float from, float to
    );

    List<CategoryStats> getCategoryStatistics();
}
