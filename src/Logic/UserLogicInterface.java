package Logic;

import Model.User;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface UserLogicInterface<T> {
    boolean add() throws SQLException, ParseException;
    String login() throws SQLException;
    boolean delete() throws SQLException;
    List<T> search() throws SQLException;
    List<T> view() throws SQLException;


}
