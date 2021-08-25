package logic;

import model.MoneyMarketFund;
import ui.MoneyMarketFundUi;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoneyMarketFundLogic {
    DbUtil dbUtil = new DbUtil();
    MoneyMarketFundUi moneyMarketFundUi = new MoneyMarketFundUi();


    public MoneyMarketFundLogic() throws SQLException, ClassNotFoundException, ParseException {
    }

    PreparedStatement preparedStatement;
    public float moneygrowth(int rate,String name) throws SQLException {

        ResultSet resultSet=dbUtil.readData("select balance,date from transaction where username='"+name+"' order by id desc limit 1");
        /*preparedStatement.setString(1,"amber");
        ResultSet resultSet=preparedStatement.executeQuery();*/
        float balance=0;
        Date date = null;
        while (resultSet.next()){
            balance=resultSet.getInt("balance");
            date=resultSet.getDate("date");

        }
        Date currentdate=new Date();
        long difference=currentdate.getTime()-date.getTime();
        TimeUnit timeUnit=TimeUnit.DAYS;
        long numberOfDays=timeUnit.convert(difference,TimeUnit.MILLISECONDS);
        System.out.println(balance);
        /*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.format(currentdate);*/

        float viewbalance= (float) (balance+(balance*((rate/100.0)/365.0)*numberOfDays));
        return viewbalance;


       /* Calendar calendar=Calendar.getInstance();
        calendar.setTime();*/
    }

    public boolean adddeposit() throws SQLException, ParseException {
        MoneyMarketFund mmfDeposit =moneyMarketFundUi.deposit();
        int result = 0;
        if (mmfDeposit.getDeposit()<1000){
            System.out.println("Amount should be more than one thousand");
        }else {
            result= dbUtil.writeData("insert into transaction(date,deposit) values('"+mmfDeposit.getDate()+"','"+mmfDeposit.getDeposit()+"')");
            /*preparedStatement.setObject(1, mmfDeposit.getDate());
            preparedStatement.setInt(2, mmfDeposit.getDeposit());*/

        }

        /*int result = preparedStatement.executeUpdate();*/
        return result == 1;
    }

    public boolean withdraw() throws SQLException, ParseException {
        MoneyMarketFund mmfwithdraw=moneyMarketFundUi.withdraw();
        int result = dbUtil.writeData("insert into transaction(date,withdraw) values('"+mmfwithdraw.getDate()+"','"+mmfwithdraw.getWithdraw()+"')");
        /*preparedStatement.setObject(1, mmfwithdraw.getDate());
        preparedStatement.setInt(2, mmfwithdraw.getWithdraw());
        int result = preparedStatement.executeUpdate();*/
        return result == 1;
    }

    public ResultSet viewtransaction() throws SQLException, ParseException {
        List<Date> startEnd = new ArrayList<Date>();
        startEnd = moneyMarketFundUi.viewtransactions();
        ResultSet resultSet=dbUtil.readData("select * from transaction where date between'"+startEnd.get(0)+"' and '"+startEnd.get(1)+"'");
        /*preparedStatement.setObject(1,  startEnd.get(0));
        preparedStatement.setObject(2,startEnd.get(1));*/
        return resultSet;
    }

}

