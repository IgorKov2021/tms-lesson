package org.example;

public enum TypeOfEmp {
    GENERAL_MANAGER(800),
    FINANCIAL(500),
    HR(400),
    AUTOMATOR(400),
    ROBOTICIST(450),

    COMMUNICATOR(500);
    private int coefficient;

    TypeOfEmp(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return  '{' + name() +
                ", coefficient=" + coefficient +
                '}';
    }
}
