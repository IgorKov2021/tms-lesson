package org.example.impl;

import lombok.Data;
import org.example.domain.Pair;
import org.example.domain.User;
import org.example.service.Bet;
import org.example.service.ServiceStarts;
import org.example.service.ValidateScanner;


import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
public class ServiceStartsImpl implements ServiceStarts, Bet {
    GeneratePairs generatePairs;
    //ValidateNumberImpl scanner;
    //ValidateBetImpl betScanner;
    List<ValidateScanner> validateScanner;

    public ServiceStartsImpl(GeneratePairs generatePairs, List<ValidateScanner> validateScanner) {
        this.generatePairs = generatePairs;
        //this.scanner = scanner;
        //this.betScanner = betScanner;
        this.validateScanner = validateScanner;
    }

    @Override
    public void startRacing() throws InterruptedException {
        System.out.println("ВАШ баланс: " + User.money);
        System.out.println("Введите сумму ставки");
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        Integer bet = validateScanner.get(0).validate(i1);
        Integer number = validateScanner.get(1).validate(i1);
        System.out.println("Гонка началась!");
        for (int i = 0; i < 5; i++) {
            System.out.println("Круг" + (i + 1));
            System.out.println("......");
            generatePairs.setSpeed();

            Thread.sleep(2000);
            if (i < 4) {
                System.out.println("Лидирует: ");
                getWinner(generatePairs.getPair1(), generatePairs.getPair3(), generatePairs.getPair2());
                System.out.println("");
            }
        }

        System.out.print("Гонка закончилась, победитель! ");
        getWin(bet, number);
        generatePairs.resetSpeed();


    }

    public List<Pair> getWinner(Pair p1, Pair p2, Pair p3) {
        List<Pair> pairList = List.of(p1, p2, p3);
        OptionalInt max = pairList.stream().mapToInt(pair -> pair.getSpeed()).max();
        List<Pair> collect = pairList.stream().filter(pair -> pair.getSpeed() == max.getAsInt()).collect(Collectors.toList());
        collect.stream().forEach(pair -> System.out.println(pair.getHorse().getName()));
        return collect;
    }

    @Override
    public void getWin(Integer bet, Integer number) {
        List<Pair> winner = getWinner(generatePairs.getPair1(), generatePairs.getPair3(), generatePairs.getPair2());

        boolean b = winner.stream().
                anyMatch(pair -> pair.getID() == number);
        if (b) {
            System.out.println("Вы выйграли: " + bet * 2);
            User.money += (bet * 2);
        } else {
            System.out.println("К сожалению вы проиграли! - " + bet);
            User.money -= bet;
            System.out.println("Ваш баланс " + User.money);
        }
    }

    @Override
    public String toString() {
        return "" + generatePairs;
    }
}
