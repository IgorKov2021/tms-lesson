package org.example.impl;

import org.example.domain.User;
import org.example.service.ValidateScanner;

import java.util.Scanner;

public class ValidateBetImpl implements ValidateScanner {
    @Override
    public Integer validate(int i) {

        if (i > User.money) {
            System.out.println("Сумма превышает баланс");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите сумму ставки");
            int i1 = scanner.nextInt();
            validate(i1);

        }
       return i;
    }
}
