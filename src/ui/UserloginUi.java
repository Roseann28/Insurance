package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserloginUi {
    Scanner scanner=new Scanner(System.in);
     public List<String> logindetails(){
        List<String> userlogin=new ArrayList<String>();
        System.out.println("Enter your Email address");
        userlogin.add(scanner.nextLine());
        System.out.println("Enter idnumber");
        userlogin.add(scanner.nextLine());
        return userlogin;
    }
}
