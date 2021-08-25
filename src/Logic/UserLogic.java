package Logic;

import Model.User;
import Ui.UserUi;
import Ui.UserloginUi;
import Util.DbUtil;
import Util.Gender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserLogic implements UserLogicInterface<User> {
    DbUtil dbUtil=new DbUtil();
    UserUi userUi=new UserUi();
    UserloginUi userloginUi=new UserloginUi();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public UserLogic() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean add() throws SQLException, ParseException {
        User user=userUi.getDetails();
        preparedStatement=dbUtil.writeData("insert into users" +
                "(name,email,krapin,address,idnumber,dateofbirth,gender)values(?,?,?,?,?,?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getKraPin());
        preparedStatement.setString(4,user.getAddress());
        preparedStatement.setInt(5,user.getIdnumber());
        preparedStatement.setObject(6,user.getDateOfBirth());
        preparedStatement.setString(7,String.valueOf(user.getGender()));
        int result=preparedStatement.executeUpdate();
        /*int result=dbUtil.writeData("insert into users(name,email,krapin,address,idnumber,dateofbirth,gender)values +('"+user.getName()+"','"+user.getEmail()+"','"+user.getKraPin()+"','"+user.getAddress()+"','"+user.getIdnumber()
                +"','"+user.getDateOfBirth()+"','"+user.getGender()+"');*/
        return result==1;
    }

    @Override
    public String login() throws SQLException {
        String username = null;
        int idno = 0;
        PreparedStatement preparedStatement=dbUtil.readData("select * from users where email=?");
        preparedStatement.setString(1,userloginUi.logindetails().get(0));
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            idno=resultSet.getInt("idnumber");
        }
        if (userloginUi.logindetails().get(1).equals(idno))
            return(userloginUi.logindetails().get(0));
        else
            return null;
    }

    @Override
    public boolean delete() throws SQLException {
        preparedStatement=dbUtil.writeData("delete from users where email=?");
        preparedStatement.setString(1,userUi.delete());
        int done=preparedStatement.executeUpdate();
        return done==1;
    }

    @Override
    public List<User> search() throws SQLException {
        preparedStatement=dbUtil.readData("select * from users where email=?");
        preparedStatement.setString(1,userUi.search());
        resultSet= preparedStatement.executeQuery();
        List<User> searcheduser=new ArrayList<User>();
        while (resultSet.next()){
            User user=new User();
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setKraPin(resultSet.getString("krapin"));
            user.setAddress(resultSet.getString("address"));
            user.setIdnumber(resultSet.getInt("idnumber"));
            user.setDateOfBirth(resultSet.getDate("dateofbirth"));
            user.setGender((Gender) resultSet.getObject("gender"));
            searcheduser.add(user);
        }
        return searcheduser;
    }
    /*int result=dbUtil.writeData("insert into users(name,email,krapin,address,idnumber,dateofbirth,gender)values +('"+user.getName()+"','"+user.getEmail()+"','"+user.getKraPin()+"','"+user.getAddress()+"','"+user.getIdnumber()
                    +"','"+user.getDateOfBirth()+"','"+user.getGender()+"');*/
    @Override
    public List<User> view() throws SQLException {
        preparedStatement=  dbUtil.readData("select * from records");
        resultSet=preparedStatement.executeQuery();
        List<User> users=new ArrayList<User>();
        while (resultSet.next()){
            User user=new User();
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setKraPin(resultSet.getString("krapin"));
            user.setAddress(resultSet.getString("address"));
            user.setIdnumber(resultSet.getInt("idnumber"));
            user.setDateOfBirth(resultSet.getDate("dateofbirth"));
            user.setGender((Gender) resultSet.getObject("gender"));
            users.add(user);
        }
        return users;
    }
}
