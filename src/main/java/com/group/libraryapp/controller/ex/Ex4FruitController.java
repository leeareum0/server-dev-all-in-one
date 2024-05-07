package com.group.libraryapp.controller.ex;

import com.group.libraryapp.dto.ex.request.Ex4FruitCreateRequest;
import com.group.libraryapp.dto.ex.request.Ex4FruitSoldRequest;
import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class Ex4FruitController {

    private final JdbcTemplate jdbcTemplate;

    public Ex4FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody Ex4FruitCreateRequest ex4FruitRequest) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ex4FruitRequest.getName(), ex4FruitRequest.getWarehousingDate(), ex4FruitRequest.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody Ex4FruitSoldRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";

        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }

        String updateSql = "UPDATE fruit SET is_sold  = true WHERE id = ?";
        jdbcTemplate.update(updateSql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public Ex4FruitSalesAmountResponse statFruit(@RequestParam String name) {

        String salesSql = "SELECT sum(price) FROM fruit WHERE is_sold = true GROUP BY name HAVING name = ?";
        String notSalesSql = "SELECT sum(price) FROM fruit WHERE is_sold = false GROUP BY name HAVING name = ?";


        long salesAmount = jdbcTemplate.queryForObject(salesSql, long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject(notSalesSql, long.class, name);


        return new Ex4FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }
}
