package com.calculator.demoRavil;

import org.springframework.web.bind.annotation.GetMapping;

public interface CalService {
    int plus(int num1, int num2);

    int minus (int num1, int num2);

    int multiply (int num1, int num2);

    int divide (int num1, int num2);
}
