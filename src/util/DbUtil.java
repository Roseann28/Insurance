package util;

import java.sql.*;

public class DbUtil {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    String url = "jdbc:mysql://localhost:3306/insurance";
    String user = "root";
    String password = "roseann";
    public DbUtil() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection(url, user, password);
    }

    @Override
    protected void finalize() throws Throwable {
        this.closeConnection();
        super.finalize();
    }

    public int writeData(String query) throws SQLException {
        statement=connection.createStatement();
        return statement.executeUpdate(query);

        /*preparedStatement=connection.prepareStatement(query);
        return preparedStatement;*/


        /*statement=connection.createStatement();
        return statement.executeUpdate(query);*/
        /*ResultSet resultSet=statement.executeQuery("select * from users");
        while (resultSet.next()){
            resultSet.getString("name");
        }*/
    }
    public ResultSet readData(String query) throws SQLException {
        statement=connection.createStatement();
        return statement.executeQuery(query);
        /*preparedStatement=connection.prepareStatement(query);
        return preparedStatement;*/

    }
    public void closeConnection() throws ClassNotFoundException, SQLException {

        statement.close();
        connection.close();


    }

}
