package com.group.libraryapp.dto.ex.response;

public class Ex2DateResponse {

    private final String dayOfTheWeek;

    public Ex2DateResponse(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
