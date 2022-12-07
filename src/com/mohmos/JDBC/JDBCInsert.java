package com.mohmos.JDBC;

import java.sql.*;

public class JDBCInsert {

    /**
     * method for inserting the value into the database
     * @param date date for the currency update
     * @param base currency
     * @param amount amount of value from the currency against the base currency
     */
    public static void insertDB(String date, String base, double amount){
        final String url = "jdbc:mysql://localhost:3306/Fixerio";
        final String username="root";
        final String password="Nettavisen123+";

        Connection connection = null;
        String querries = "INSERT INTO base VALUES ( ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection= DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(querries);
            statement.setString(1, date);
            statement.setString(2, base);
            statement.setDouble(3, amount);

            int result = statement.executeUpdate();

            if(result > 0){
                System.out.println("insertion is completed");
            }
            else
                System.out.println("unsuccessful insertion ");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
