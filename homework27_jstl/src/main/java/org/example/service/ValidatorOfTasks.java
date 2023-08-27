package org.example.service;

public class ValidatorOfTasks implements TaskValidator {
    @Override
    public Boolean isValid(String task) {
        if (task == null || task.isBlank()) {
            return false;
        }
        return true;

    }
}
