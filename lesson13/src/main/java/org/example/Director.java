package org.example;

public class Director extends Employee {
    private TypeOfDirector typeOfDirector;
    private int yearsOfExperience;

    public TypeOfDirector getTypeOfDirectors() {
        return typeOfDirector;
    }

    Director(TypeOfDirector typeOfDirector, int yearsOfExperience) {
        this.typeOfDirector = typeOfDirector;
        this.yearsOfExperience = yearsOfExperience;
    }


    public static void main(String[] args) {
        Director d1 = new Director(TypeOfDirector.FINANCIAL, 4);
        System.out.println(d1);
        System.out.println(d1.getSalary(TypeOfDirector.HR.getCoefficient(), d1.yearsOfExperience));


    }
}
