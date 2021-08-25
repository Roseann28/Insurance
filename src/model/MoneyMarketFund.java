package model;

import java.util.Date;

public class MoneyMarketFund{
    private int deposit;
    private int withdraw;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public String toString() {
        return deposit+"," + withdraw+"," + date ;
    }
}
