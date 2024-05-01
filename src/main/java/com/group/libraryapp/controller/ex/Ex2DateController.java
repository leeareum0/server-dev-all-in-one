package com.group.libraryapp.controller.ex;

import com.group.libraryapp.dto.ex.response.Ex2DateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class Ex2DateController {

    @GetMapping("/api/v1/day-of-the-week")
    public Ex2DateResponse ex2Date(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return new Ex2DateResponse(String.valueOf(localDate.getDayOfWeek()).substring(0, 3));
    }
}
