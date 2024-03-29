package com.example.json_ex.productshop.entities.users;

import com.example.json_ex.productshop.entities.products.SoldProductDTO;

import java.util.List;

public class UserWithSoldProductDTO {
    private String firstName;
    private String lastName;
    private List<SoldProductDTO> itemsBought;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<SoldProductDTO> getItemsBought() {
        return itemsBought;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setItemsBought(List<SoldProductDTO> itemsBought) {
        this.itemsBought = itemsBought;
    }
}
