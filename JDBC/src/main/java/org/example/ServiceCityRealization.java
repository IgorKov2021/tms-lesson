package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCityRealization implements Service <City>{
    @Override
    public void add(City city) {

            try {
                Connection connection = DBUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT into cities values" +
                        " (?, ?)");
                preparedStatement.setInt(1, city.getIdCity());
                preparedStatement.setString(2, city.getName());

                preparedStatement.execute();
                connection.close();


            } catch (Exception e) {
                System.out.println("ERROR in add City!");
            }
        }


    @Override
    public void showAll() {
        List<City> listOfCities = new ArrayList<>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name_city as city, id " +
                   " from cities");


            while (resultSet.next()) {

                String cityName = resultSet.getString("city");

                Integer cityId = resultSet.getInt("id");
                City city = new City(cityId, cityName);
                listOfCities.add(city);
                System.out.println("[CityID: " + cityId+ " city: " + cityName  + " ]");

            }
            connection.close();
        } catch (Exception e) {
            System.out.println("ERROR in show information of Cities!");
        }
    }

    @Override
    public void delete(City city) {

            try {
                Connection connection = DBUtils.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT st.id from students st join cities ct on ct.id = st.id_city where ct.name_city = ?");
                preparedStatement.setString(1, city.getName());
                ResultSet resultSet = preparedStatement.executeQuery();

                Connection connection1 = DBUtils.getConnection();
                connection1.setAutoCommit(false);

                while (resultSet.next()) {
                    int number = resultSet.getInt("id");
                    PreparedStatement preparedStatement1 = connection1.prepareStatement("UPDATE students SET id_city = NULL where id = ?");
                    preparedStatement1.setInt(1, number);
                    preparedStatement1.execute();
                    connection1.commit();

                }
                connection.close();
                Connection connection2 = DBUtils.getConnection();
                connection2.setAutoCommit(false);
                PreparedStatement preparedStatement1 = connection2.prepareStatement("DELETE FROM cities WHERE id = ?");
                preparedStatement1.setInt(1, city.getIdCity());
                preparedStatement1.execute();
                connection2.commit();
                connection.close();

                connection1.close();

                connection2.close();



            } catch (Exception e) {
                System.out.println("ERROR in delete City!");
            }
        }
    }
