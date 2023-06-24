package com.example.Calculator.Controller;

import com.example.Calculator.DTO.CalculationRequest;
import com.example.Calculator.DTO.CalculationResponse;
import com.example.Calculator.Service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Calculator")
public class CalulatorController {

    private CalculatorService calculatorService;

    public CalulatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@RequestBody CalculationRequest request) {
        int result = calculatorService.add(request.getA(), request.getB());
        CalculationResponse response = new CalculationResponse(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
