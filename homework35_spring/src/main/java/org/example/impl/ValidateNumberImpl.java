package org.example.impl;

import org.example.domain.User;
import org.example.service.ValidateScanner;

import java.util.Scanner;

public class ValidateNumberImpl implements ValidateScanner {
    @Override
    public Integer validate(int i) {
        System.out.println("Выберите участника:");
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        if (number == 1 || number == 2 || number == 3 ) {
            System.out.println("Поехали");
            return number;



        } else {
            System.out.println("Неправильный ввод, введите 1,2 или 3!");
            int i1 = scanner.nextInt();
            validate(i1);
            return null;
        }

    }
}
