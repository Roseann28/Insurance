package ui;

import model.Admin;

import java.util.Scanner;

public class AdminUi {
    Admin admin = new Admin();
    Scanner scanner = new Scanner(System.in);

    public Admin credentials() {
        System.out.println("Enter your username");
        admin.setUsername(scanner.nextLine());
        System.out.println("Enter password");
        admin.setPassword(scanner.nextLine());
        return admin;

    }

    public String delete() {
        System.out.println("Enter username");
        String delete = scanner.nextLine();
        return delete;
    }

    public String search() {
        System.out.println("Enter username");
        String email = scanner.nextLine();
        return email;
    }
    public int rateinput(){
        System.out.println("Enter rate");
        int rateinput=scanner.nextInt();
        scanner.nextLine();
        return rateinput;
    }
}
