package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            randomList.add(new Random().nextInt(50));
        }
        System.out.println(randomList);
        //Удалить дубликаты
        List<Integer> collect = randomList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Удалённые дубликаты " + collect);

        // Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
        System.out.println("Элементы в диапазоне от 7 до 17");
        randomList.stream()
                .filter(digit -> digit >= 7)
                .filter(digit -> digit <= 17)
                .forEach(System.out::println);
        System.out.println("---------------------");

        // Каждый элемент умножить на 2
        List<Integer> randomListMultipleTwo = randomList.stream()
                .map(digit -> digit * 2)
                .collect(Collectors.toList());
        System.out.println("Умножение на два " + randomListMultipleTwo);

        // Отсортировать и вывести на экран первых 4 элемента
        List<Integer> randomListFourElements = randomList.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Первых 4 элемента " + randomListFourElements);
        // Вывести количество элементов в стриме
        long countAllElements = randomList.stream()
                .count();
        System.out.println("Количество элементов: " + countAllElements);

        //Вывести среднее арифметическое всех чисел в стриме
        OptionalDouble average = randomList.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        if(average.isPresent()) {
        double averageRandomList = average.getAsDouble();
        System.out.println("Среднее арифметическое всех чисел в стриме " + averageRandomList);
        }



    }
}