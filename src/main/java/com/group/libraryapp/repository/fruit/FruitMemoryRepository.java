package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.ex.response.Ex4FruitSalesAmountResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Primary
@Repository
public class FruitMemoryRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitMemoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    @Override
    public boolean isFruitNotExist(long id) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    @Override
    public void updateFruit(long id) {
        String updateSql = "UPDATE fruit SET is_sold  = true WHERE id = ?";
        jdbcTemplate.update(updateSql, id);
    }

    @Override
    public boolean isFruitNotExist(String name) {
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();

    }

    @Override
    public Ex4FruitSalesAmountResponse statFruit(String name) {
        String salesSql = "SELECT sum(price) FROM fruit WHERE is_sold = true GROUP BY name HAVING name = ?";
        String notSalesSql = "SELECT sum(price) FROM fruit WHERE is_sold = false GROUP BY name HAVING name = ?";

        long salesAmount = jdbcTemplate.queryForObject(salesSql, long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject(notSalesSql, long.class, name);

        return new Ex4FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }
}
