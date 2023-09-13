package org.example.impl;

import org.example.domain.User;
import org.example.service.ValidateScanner;

import java.util.Scanner;

public class ValidateBetImpl implements ValidateScanner {
    @Override
    public Integer validate() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму ставки");
        Integer sum = scanner.nextInt();
        if (sum > User.money) {
            System.out.println("Сумма превышает баланс");
            validate();
        }
        return sum;
    }
}
