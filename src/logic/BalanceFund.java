package logic;

import ui.MoneyMarketFundUi;

import java.sql.SQLException;
import java.text.ParseException;

public class BalanceFund extends MoneyMarketFundLogic {
    public BalanceFund() throws SQLException, ClassNotFoundException, ParseException {
    }
    void firstdeposit() throws ParseException {
        MoneyMarketFundUi moneyMarketFundUi=new MoneyMarketFundUi();
        int amount=moneyMarketFundUi.deposit().getDeposit();
        if(amount<5000)
            System.out.println("You cannot deposit anything less than 5000");

    }

}
