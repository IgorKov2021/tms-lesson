package org.example;

public class Engineer extends Employee{
    private int yearsOfExperience;
    private TypeOfEngineer typeOfEngineer;

    public TypeOfEngineer getTypeOfEngineers() {
        return typeOfEngineer;
    }

    Engineer(TypeOfEngineer typeOfEngineer, int yearsOfExperience) {
        this.typeOfEngineer = typeOfEngineer;
        this.yearsOfExperience = yearsOfExperience;
    };


}
