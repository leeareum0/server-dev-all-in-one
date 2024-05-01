package com.group.libraryapp.controller.ex;

import com.group.libraryapp.dto.ex.request.Ex1CalcRequest;
import com.group.libraryapp.dto.ex.response.Ex1CalcResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1CalcController {

    @GetMapping("/api/v1/calc")
    public Ex1CalcResponse ex1CalcNumbers(Ex1CalcRequest request) {
        return new Ex1CalcResponse(request.getNum1(), request.getNum2());
    }
}
