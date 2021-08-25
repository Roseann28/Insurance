import Logic.AdminUserLogic;
import Logic.MoneyMarketFundLogic;
import Logic.UserLogic;
import Ui.AdminUi;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws SQLException, ParseException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        UserLogic userLogic=new UserLogic();

        System.out.println("Welcome to our insurance system");
        System.out.println("1. login");
        System.out.println("2. sign up");
        System.out.println("3. administrator");
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                if (userLogic.login()!=null){
                    transactionSection(scanner);
                }
                break;
            case 2:
                if (userLogic.add()){
                    System.out.println("User Added");
                }else
                    System.out.println("User is not added");
                break;
            case 3:
                adminduties();




        }


        /*AdminUserLogic admin=new AdminUserLogic();
        if (admin.add()){
            System.out.println("User Added");
        }else
            System.out.println("User is not added");*/

       /* MoneyMarketFundLogic moneyMarketFundLogic=new MoneyMarketFundLogic();*/
        /*if (moneyMarketFundLogic.adddeposit())
            System.out.println("done");
        else
            System.out.println("not done");*/

        /*if (moneyMarketFundLogic.withdraw())
            System.out.println("done");
        else
            System.out.println("not done");*/

        /*ResultSet resultSet=moneyMarketFundLogic.viewtransaction();
        List<String> viewlist=new ArrayList<String>();
        MoneyMarketFund moneyMarketFund=new MoneyMarketFund();
        while (resultSet.next()){
            viewlist.add(resultSet.getString("date")+resultSet.getInt("deposit")+
                    resultSet.getInt("withdraw"));
        }
        System.out.println(viewlist);*/

        /*float x=moneyMarketFundLogic.moneygrowth(8);
        System.out.println(x);*/




    }

    private static int adminduties() throws SQLException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        UserLogic userLogic=new UserLogic();
        AdminUserLogic adminUserLogic=new AdminUserLogic();
        AdminUi adminUi=new AdminUi();
        int rates = 0;
        if (adminUserLogic.login()!=null){
            rates=adminUi.rateinput();
        }
        System.out.println("Enter function:" +
                "1.Delete user" +
                "2.search user" +
                "3.view users" +
                "4.delete admins" +
                "5.search admins" +
                "6. view admins");
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                userLogic.delete();
                break;
            case 2:
                userLogic.search();
                break;
            case 3:
                userLogic.view();
                break;
            case 4:
                adminUserLogic.delete();
                break;
            case 5:
                adminUserLogic.search();
                break;
            case 6:
                adminUserLogic.view();
                break;


        }
        return rates;
    }

    private static void transactionSection(Scanner scanner) throws SQLException, ParseException, ClassNotFoundException {
        MoneyMarketFundLogic mmflogic=new MoneyMarketFundLogic();
        System.out.println("Would you like to" +
                "1.Deposit" +
                "2.Withdraw" +
                "3.view Transactions" +
                "4.view balance");
        int pick=scanner.nextInt();
        scanner.nextLine();
        switch (pick){
            case 1:
                mmflogic.adddeposit();
                break;
            case 2:
                mmflogic.withdraw();
                break;
            case 3:
                mmflogic.viewtransaction();
            case 4:
                mmflogic.moneygrowth(adminduties());
                break;

        }

    }
}
/*
moneyMarketFund.setDate(resultSet.getDate("date"));
        moneyMarketFund.setDeposit(resultSet.getInt("deposit"));
        moneyMarketFund.setWithdraw(resultSet.getInt("withdraw"));*/
