package org.example;

public enum TypeOfWorkers {
    GENERAL_MANAGER(800),
    FINANCIAL(500),
    HR(400),
    AUTOMATOR(400),
    ROBOTICIST(450),

    COMMUNICATOR(500);
     private int coefficient;
    TypeOfWorkers(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return "TypeOfWorkers{" + name()+
                ", coefficient=" + coefficient +
                '}';
    }
}
