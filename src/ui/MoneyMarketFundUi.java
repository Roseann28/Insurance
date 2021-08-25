package ui;

import model.MoneyMarketFund;
import util.ClassUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MoneyMarketFundUi {
    public MoneyMarketFundUi(){

    }
    ClassUtil classUtil=new ClassUtil();
    MoneyMarketFund moneyMarketFund=new MoneyMarketFund();
    Scanner scanner=new Scanner(System.in);
    public MoneyMarketFund withdraw() throws ParseException {
        System.out.println("How much would you like to withdraw");
        int withdraws=scanner.nextInt();
        scanner.nextLine();
        moneyMarketFund.setWithdraw(withdraws);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String transactiondate=simpleDateFormat.format(date);
        moneyMarketFund.setDate(classUtil.convertDate(transactiondate));
        return moneyMarketFund;
    }
    public MoneyMarketFund deposit() throws ParseException {
        System.out.println("How much would you like to deposit");
        int deposits=scanner.nextInt();
        scanner.nextLine();
        moneyMarketFund.setDeposit(deposits);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String transactiondate=simpleDateFormat.format(date);
        moneyMarketFund.setDate(classUtil.convertDate(transactiondate));
        return moneyMarketFund;
    }
    public List<Date> viewtransactions() throws ParseException {
        List<Date> startandend=new ArrayList<Date>();
        System.out.println("Enter the start date and end date of transactions you would like to view");
        Date start=classUtil.convertDate(scanner.nextLine());
        startandend.add(start);
        Date end=classUtil.convertDate(scanner.nextLine());
        startandend.add(end);
        return startandend;
    }

}
