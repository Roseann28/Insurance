package Util;

import java.sql.*;

public class DbUtil {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    public DbUtil() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","roseann");


    }
    public PreparedStatement writeData(String query) throws SQLException {
        preparedStatement=connection.prepareStatement(query);
        return preparedStatement;
        /*statement=connection.createStatement();
        return statement.executeUpdate(query);*/
        /*ResultSet resultSet=statement.executeQuery("select * from users");
        while (resultSet.next()){
            resultSet.getString("name");
        }*/
    }
    public PreparedStatement readData(String query) throws SQLException {
        preparedStatement=connection.prepareStatement(query);
        return preparedStatement;

    }
    public void dbconnect() throws ClassNotFoundException, SQLException {

        statement.close();
        connection.close();


    }

}
