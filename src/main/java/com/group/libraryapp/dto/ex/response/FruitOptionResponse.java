package com.group.libraryapp.dto.ex.response;

import com.group.libraryapp.domain.user.Fruit;

import java.time.LocalDate;

public class FruitOptionResponse {

    private String name;
    private long price;
    private LocalDate warehousingDate;

    public FruitOptionResponse(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousingDate();
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
