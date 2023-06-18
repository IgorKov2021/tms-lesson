package org.example;

public class Engineer extends Employee{

    private TypeOfEngineer typeOfEngineer;

    public TypeOfEngineer getTypeOfEngineers() {
        return typeOfEngineer;
    }

    public void setTypeOfEngineer(TypeOfEngineer engineer) {
        this.typeOfEngineer = engineer;
    }
    public int getCoefficientOfEngineer() {
        return typeOfEngineer.getCoefficient();
    }

    @Override
    public String toString() {
        return "Engineer{" + " " + getName() + " " +
                getSurname() + " " + "Sex: " + getSex() +" " +  typeOfEngineer.name()   + " YearsOfExperience: "
                +getYearsOfExperience()+
                '}';
    }
}
