package org.example.impl;

import org.example.domain.User;
import org.example.service.ValidateScanner;

import java.util.Scanner;

public class ValidateNumberImpl implements ValidateScanner {
    @Override
    public Integer validate() {
        System.out.println("Выберите участника:");
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        if (number == 1 || number == 2 || number == 3 ) {
            System.out.println("Поехали");


        } else {
            System.out.println("Неправильный ввод, введите 1,2 или 3!");
            validate();
        }
        return number;
    }
}
