package com.example.json_ex.productshop;

import com.example.json_ex.productshop.entities.categories.CategoryStats;
import com.example.json_ex.productshop.entities.products.ProductWithoutBuyerDTO;
import com.example.json_ex.productshop.entities.users.UserWithSoldProductDTO;
import com.example.json_ex.productshop.services.ProductService;
import com.example.json_ex.productshop.services.SeedService;
import com.example.json_ex.productshop.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductShopRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final Gson gson;
    private final UserService userService;

    @Autowired
    public ProductShopRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;

        this.gson = new GsonBuilder()
                .setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
        // this.seedService.seedAll();

        //productsBetweenPriceWithoutBuyer();

        //getUsersWithSoldProducts();

        List<CategoryStats> categoryStatistics = this.productService.getCategoryStatistics();

        String json = this.gson.toJson(categoryStatistics);
        System.out.println(json);

    }

    private void getUsersWithSoldProducts() {
        List<UserWithSoldProductDTO> usersWithSoldProducts = this.userService.getUsersWithSoldProducts();

        String json = this.gson.toJson(usersWithSoldProducts);

        System.out.println(json);
    }

    private void productsBetweenPriceWithoutBuyer() {
        List<ProductWithoutBuyerDTO> productsForSell = this.productService.getProductsInPriceRangeForSell(
                500,
                1000);

        String json = this.gson.toJson(productsForSell);

        System.out.println(json);
    }
}
