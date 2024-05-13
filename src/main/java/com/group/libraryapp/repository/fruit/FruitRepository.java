package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;

import java.time.LocalDate;

public interface FruitRepository {

    void saveFruit(String name, LocalDate warehousingDate, long price);
    void updateFruit(long id);
    Ex4FruitSalesAmountResponse statFruit(String name);
    boolean isFruitNotExist(long id);
    boolean isFruitNotExist(String name);
}
