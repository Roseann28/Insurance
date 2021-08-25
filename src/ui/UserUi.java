package ui;

import model.User;
import util.ClassUtil;
import util.Gender;

import java.text.ParseException;
import java.util.Scanner;

public class UserUi {
    Scanner scanner=new Scanner(System.in);
    public User getDetails() throws ParseException {
        User user=new User();
        ClassUtil classUtil=new ClassUtil();

        System.out.println("Enter name:");
        user.setName(scanner.nextLine());

        System.out.println("Enter Krapin:");
        user.setKraPin(scanner.nextLine());

        System.out.println("Enter address:");
        user.setAddress(scanner.nextLine());

        System.out.println("Enter email:");
        user.setEmail(scanner.nextLine());

        System.out.println("Enter idnumber:");
        user.setIdnumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter date of birth:");
        user.setDateOfBirth(classUtil.convertDate(scanner.nextLine()));

        System.out.println("Enter gender:");
        user.setGender(Gender.valueOf(scanner.nextLine()));

        return user;
    }
    public String delete() {
        System.out.println("Enter email address");
        String delete=scanner.nextLine();
        return delete;
    }
    public String search(){
        System.out.println("Enter email");
        String email = scanner.nextLine();
        return email;



    }
}
