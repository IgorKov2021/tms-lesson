package org.example;

public enum TypeOfEngineer {
    AUTOMATOR(400),
    ROBOTICIST(450),

    COMMUNICATOR(500);
    private int coefficient;

    TypeOfEngineer(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
