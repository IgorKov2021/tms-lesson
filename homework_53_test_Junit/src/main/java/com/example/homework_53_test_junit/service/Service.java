package com.example.homework_53_test_junit.service;

import com.example.homework_53_test_junit.exceptions.NullStringException;

public class Service {
    public int findIndexInString(String str, String substr) {
        if(str != null && substr != null) {
            return str.toLowerCase().indexOf(substr.toLowerCase());
        }
        throw new NullStringException();

    }
}
