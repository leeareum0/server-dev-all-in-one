package com.group.libraryapp.controller.ex;

import com.group.libraryapp.dto.ex.request.Ex3NumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex3NumController {

    @PostMapping("/numbers")
    public int getNumbers(@RequestBody Ex3NumRequest numRequest) {

        Integer[] numbers = numRequest.getNumbers();
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
