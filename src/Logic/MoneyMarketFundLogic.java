package Logic;

import Model.MoneyMarketFund;
import Ui.MoneyMarketFundUi;
import Util.DbUtil;

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
    public float moneygrowth(int rate) throws SQLException {

        preparedStatement=dbUtil.readData("select balance,date from transaction where username=? order by id desc limit 1");
        preparedStatement.setString(1,"amber");
        ResultSet resultSet=preparedStatement.executeQuery();
        float balance=7;
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
        if (mmfDeposit.getDeposit()<1000){
            System.out.println("Amount should be more than one thousand");
        }else {
            preparedStatement= dbUtil.writeData("insert into transaction(date,deposit) values(?,?)");
            preparedStatement.setObject(1, mmfDeposit.getDate());
            preparedStatement.setInt(2, mmfDeposit.getDeposit());

        }

        int result = preparedStatement.executeUpdate();
        return result == 1;
    }

    public boolean withdraw() throws SQLException, ParseException {
        MoneyMarketFund mmfwithdraw=moneyMarketFundUi.withdraw();
        preparedStatement = dbUtil.writeData("insert into transaction(date,withdraw) values(?,?)");
        preparedStatement.setObject(1, mmfwithdraw.getDate());
        preparedStatement.setInt(2, mmfwithdraw.getWithdraw());
        int result = preparedStatement.executeUpdate();
        return result == 1;
    }

    public ResultSet viewtransaction() throws SQLException, ParseException {
        List<Date> startEnd = new ArrayList<Date>();
        startEnd = moneyMarketFundUi.viewtransactions();
        PreparedStatement preparedStatement=dbUtil.readData("select * from transaction where date between ? and ?");
        preparedStatement.setObject(1,  startEnd.get(0));
        preparedStatement.setObject(2,startEnd.get(1));
        return preparedStatement.executeQuery();
    }

}

