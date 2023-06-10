package com.calculator.demoRavil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorCon {
    private final CalculatorService calculatorService;

    public CalculatorCon(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
}
    @GetMapping (path = "/plus" )
    public String plus (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.plus (num1,num2);
        return vivod (num1,num2,result, '+');
    }
    @GetMapping (path = "/minus" )
    public String minus (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.minus(num1,num2);
        return vivod (num1,num2,result, '-');
    }
    @GetMapping (path = "/multiply" )
    public String multiply (@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1,num2);
        return vivod (num1,num2,result, '*');
    }
    @GetMapping (path = "/divide" )
    public String divide (@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "на ноль делить нельзя";
        }
        int result = calculatorService.divide(num1,num2);
        return vivod (num1,num2,result, '/');
    }
    public String vivod (int num1, int num2,int result,char simvol){
        return String.format("%d %c %d = %d", num1, simvol, num2, result );
    }
}
