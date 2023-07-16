package org.example;

public class City {
    private String name;
    private Integer idCity;

    public String getName() {
        return name;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public City(Integer idCity, String name) {
        this.name = name;
        this.idCity = idCity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
