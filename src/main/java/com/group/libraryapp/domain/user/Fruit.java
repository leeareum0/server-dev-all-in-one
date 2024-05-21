package com.group.libraryapp.domain.user;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate warehousingDate;

    private Long price;

    @Column(nullable = false)
    private Boolean isSold;

    protected Fruit() {

    }

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void updateIsSold(Boolean isSold) {
        this.isSold = isSold;
    }

    public boolean isSold() {
        return isSold;
    }
}
