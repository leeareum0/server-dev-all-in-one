package com.group.libraryapp.service.fruit;


import com.group.libraryapp.dto.ex.request.Ex4FruitCreateRequest;
import com.group.libraryapp.dto.ex.request.Ex4FruitSoldRequest;
import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(Ex4FruitCreateRequest request) {
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(Ex4FruitSoldRequest request) {
        if (fruitRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        fruitRepository.updateFruit(request.getId());
    }

    public Ex4FruitSalesAmountResponse statFruit(String name) {
        if (fruitRepository.isFruitNotExist(name)) {
            throw new IllegalArgumentException();
        }
        return fruitRepository.statFruit(name);
    }
}
