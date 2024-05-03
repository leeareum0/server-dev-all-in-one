package com.group.libraryapp.dto.ex.request;

import java.time.LocalDate;

public class Ex4FruitRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public Ex4FruitRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}

