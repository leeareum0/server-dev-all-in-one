package com.group.libraryapp.dto.ex.response;

public class FruitCountResponse {

    private long count;

    public FruitCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
