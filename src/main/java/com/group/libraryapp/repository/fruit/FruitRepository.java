package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.user.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findAllByNameAndIsSold(String name, boolean isSold);
    long countAllByName(String name);
    List<Fruit> findByPriceGreaterThanEqual(long price);
    List<Fruit> findByPriceLessThanEqual(long price);
}
