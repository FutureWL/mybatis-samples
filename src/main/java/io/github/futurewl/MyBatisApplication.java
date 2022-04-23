package io.github.futurewl;

import java.sql.*;

/**
 * 功能描述：MyBatis 案例记录
 */
public class MyBatisApplication {
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306";
    public static final String username = "root";
    public static final String password = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "show databases ";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Database"));
        }
    }
}
