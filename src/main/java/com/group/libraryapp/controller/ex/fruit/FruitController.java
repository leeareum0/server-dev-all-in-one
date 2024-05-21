package com.group.libraryapp.controller.ex.fruit;

import com.group.libraryapp.dto.ex.request.Ex4FruitCreateRequest;
import com.group.libraryapp.dto.ex.request.Ex4FruitSoldRequest;
import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;
import com.group.libraryapp.dto.ex.response.FruitCountResponse;
import com.group.libraryapp.dto.ex.response.FruitOptionResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody Ex4FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody Ex4FruitSoldRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public Ex4FruitSalesAmountResponse statFruit(@RequestParam String name) {
        return fruitService.statFruit(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse getFruitCount(@RequestParam String name) {
        return fruitService.getFruitCount(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitOptionResponse> getFruitList(@RequestParam String option, @RequestParam long price) {
        return fruitService.getFruitList(option, price);
    }
}
