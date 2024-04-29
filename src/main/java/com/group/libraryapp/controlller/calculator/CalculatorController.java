package com.group.libraryapp.controlller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //클래스를 api 진입지점으로 만들어준다.
public class CalculatorController {

    @GetMapping("/add") //GET /add
    public int addTwoNumbers(@RequestParam  int number1, @RequestParam int number2) {
        return number1 + number2;
    }
}
