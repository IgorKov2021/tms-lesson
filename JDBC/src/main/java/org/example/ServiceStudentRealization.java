package org.example;

import java.sql.*;

public class ServiceStudentRealization implements Service <Student> {
    @Override
    public void add(Student st) {

            try {
                Connection connection = DBUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT into students values" +
                        " (?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, st.getId());
                preparedStatement.setString(2, st.getName());
                preparedStatement.setString(3, st.getSurname());
                preparedStatement.setDate(4, new Date(st.getDataOfBirthday().getTime()));
                preparedStatement.setInt(5, st.getId_city());

                preparedStatement.execute();
                connection.close();


            } catch (Exception e) {
                System.out.println("ERROR in add Student!");
            }

        }


    @Override
    public void showAll() {

//        List<Student> listOfStudents = new ArrayList<>();
//        List<City> listOfCities = new ArrayList<>();
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ct.name_city as city, st.name," +
                    " st.surname, " +
                    "st.dataofBirthday as data, st.id, st.id_city" +
                    " from students st LEFT JOIN cities ct on st.id_city = ct.id");


            while (resultSet.next()) {
                String studentName = resultSet.getString("name");
                String cityName = resultSet.getString("city");
                String studentSurname = resultSet.getString("surname");
                Integer studentId = resultSet.getInt("id");
                Date studentData = resultSet.getDate("data");
                Integer citytId = resultSet.getInt("id_city");
               // City city = new City(citytId, cityName);
                //Student student = new Student(studentId, studentName, studentSurname, studentData, citytId);
               // listOfStudents.add(student);
                //listOfCities.add(city);
                System.out.println("[Student: " + studentId + " Name " + studentName +
                        " Surname " + studentSurname  + " dataOfBirthday "
                        + studentData + " city: " + cityName  + " ]");

            }
            connection.close();
        } catch (Exception e) {
            System.out.println("ERROR in show information of Students!");
        }

    }



    @Override
    public void delete(Student st) {
        try {
            Connection connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students " +
                    "WHERE id = ?");
            preparedStatement.setInt(1, st.getId());
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println("ERROR delete student!");
        }
    }




}
