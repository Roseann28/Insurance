package logic;

import model.Admin;
import ui.AdminUi;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminUserLogic implements UserLogicInterface<Admin> {
    DbUtil dbUtil=new DbUtil();
    AdminUi adminUi=new AdminUi();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Admin admin=adminUi.credentials();
    public AdminUserLogic() throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean add() throws SQLException {
        int result=dbUtil.writeData("insert into adminaccess(username,password) values ('"+admin.getUsername()+"','"+admin.getPassword()+"')");
        /*preparedStatement.setString(1,admin.getUsername());
        preparedStatement.setString(2,admin.getPassword());
        int result=preparedStatement.executeUpdate();*/

        return result==1;
    }

    @Override
    public String login() throws SQLException {
        String username = adminUi.credentials().getUsername();
        String password=adminUi.credentials().getPassword();
        String splpassword = null;
        ResultSet resultSet=dbUtil.readData("select * from adminaccess where username='"+username+"'");
        /*preparedStatement.setString(1,username);
        ResultSet resultSet=preparedStatement.executeQuery();*/
        while(resultSet.next()){
            splpassword=resultSet.getString("idnumber");
        }
        if (password.equals(splpassword))
            return username;
        else
            return null;
    }

    @Override
    public boolean delete() throws SQLException {
        int done=dbUtil.writeData("delete from adminaccess where username='"+delete()+"'");
        /*preparedStatement.setString(1,adminUi.delete());
        int done=preparedStatement.executeUpdate();*/
        return done==1;
    }

    @Override
    public List<Admin> search() throws SQLException {
        resultSet=dbUtil.readData("select * from adminaccess where username='"+search()+"'");
        /*preparedStatement.setString(1,adminUi.search());
        resultSet= preparedStatement.executeQuery();*/
        List<Admin> searchadmin=new ArrayList<Admin>();
        while (resultSet.next()){
            Admin admin=new Admin();
            admin.setUsername(resultSet.getString("username"));
            admin.setPassword(resultSet.getString("password"));
            searchadmin.add(admin);
        }
        return searchadmin;
    }

    @Override
    public List<Admin> view() throws SQLException {
        resultSet=  dbUtil.readData("select * from adminaccess");
        /*resultSet=preparedStatement.executeQuery();*/
        List<Admin> administators=new ArrayList<Admin>();
        while (resultSet.next()){
            Admin admin=new Admin();
            admin.setUsername(resultSet.getString("username"));
            admin.setPassword(resultSet.getString("password"));
            administators.add(admin);
        }
        return administators;
    }
}
