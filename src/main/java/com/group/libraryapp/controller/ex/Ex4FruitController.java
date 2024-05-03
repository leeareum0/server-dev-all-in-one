package com.group.libraryapp.controller.ex;

import com.group.libraryapp.dto.ex.request.Ex4FruitRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex4FruitController {

    private final JdbcTemplate jdbcTemplate;

    public Ex4FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody Ex4FruitRequest ex4FruitRequest) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ex4FruitRequest.getName(), ex4FruitRequest.getWarehousingDate(), ex4FruitRequest.getPrice());
    }
}
