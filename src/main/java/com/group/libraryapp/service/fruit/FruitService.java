package com.group.libraryapp.service.fruit;


import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.dto.ex.request.Ex4FruitCreateRequest;
import com.group.libraryapp.dto.ex.request.Ex4FruitSoldRequest;
import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;
import com.group.libraryapp.dto.ex.response.FruitCountResponse;
import com.group.libraryapp.dto.ex.response.FruitOptionResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(Ex4FruitCreateRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    public void updateFruit(Ex4FruitSoldRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        fruit.updateIsSold(true);
        fruitRepository.save(fruit);
    }

    public Ex4FruitSalesAmountResponse statFruit(String name) {
        long salesAmount = fruitRepository.findAllByNameAndIsSold(name,true)
                .stream().mapToLong(Fruit::getPrice).sum();
        long notSalesAmount = fruitRepository.findAllByNameAndIsSold(name,false)
                .stream().mapToLong(Fruit::getPrice).sum();

        return new Ex4FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }

    public FruitCountResponse getFruitCount(String name) {
        return new FruitCountResponse(fruitRepository.countAllByName(name));

    }

    public List<FruitOptionResponse> getFruitList(String option, long price) {
        List<Fruit> fruits;

        if (option.equals("GTE")) {
            fruits = fruitRepository.findByPriceGreaterThanEqual(price);
        } else if (option.equals("LTE")) {
            fruits = fruitRepository.findByPriceLessThanEqual(price);
        } else {
            throw new IllegalArgumentException();
        }

        return fruits.stream()
                .filter(fruit -> !fruit.isSold())
                .map(FruitOptionResponse::new)
                .toList();
    }
}
