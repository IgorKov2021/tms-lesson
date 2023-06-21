package org.example;

public enum TypeOfDirector {
    GENERAL_MANAGER(800),
    FINANCIAL(500),
    HR(400);
     private int coefficient;
    TypeOfDirector(int coefficient) {
        this.coefficient = coefficient;
    }
    public int getCoefficient() {
        return this.coefficient;
    }


    @Override
    public String toString() {
        return "TypeOfDirectors{" +
                "coefficient=" + coefficient +
                '}';
    }
}
