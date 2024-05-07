package com.group.libraryapp.dto.ex.response;

public class Ex4FruitSalesAmountResponse {

    private long salesAmount;
    private long notSalesAmount;

    public Ex4FruitSalesAmountResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
