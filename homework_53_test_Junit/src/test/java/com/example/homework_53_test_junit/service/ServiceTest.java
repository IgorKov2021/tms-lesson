package com.example.homework_53_test_junit.service;

import com.example.homework_53_test_junit.exceptions.NullStringException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    @AfterEach
    public void print() {
        System.out.println("--------");
    }

    @Test
    public void testResultTrue() {

        Service service = new Service();
        String strA = "Hello word";
        String strB = "word";

        int result = service.findIndexInString(strA, strB);

        Assertions.assertEquals(6, result);
    }

    @Test
    public void testResultFalse() {

        Service service = new Service();
        String strA = "Hello word";
        String strB = "word!";

        int result = service.findIndexInString(strA, strB);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testResultCaseSensitiveStr() {

        Service service = new Service();
        String strA = "HelloWord";
        String strB = "wOrD";

        int result = service.findIndexInString(strA, strB);

        Assertions.assertEquals(5, result);
    }

    @Test
    public void testResultCaseSensitiveSubstr() {

        Service service = new Service();
        String strA = "HeLLo Word";
        String strB = "hello";

        int result = service.findIndexInString(strA, strB);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testResultStrNull() {

        Service service = new Service();
        String strA = null;
        String strB = "hello";


        Assertions.assertThrows(NullStringException.class, () -> service.findIndexInString(null, strB));
    }

    @Test
    public void testResultSubstrNull() {

        Service service = new Service();
        String strA = "Hello Word!";
        String strB = null;


        Assertions.assertThrows(NullStringException.class, () -> service.findIndexInString(strA, strB));
    }
}