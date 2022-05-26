package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Welcome
        System.out.println("Welcome to Super Password Generator!");

        //Login section
        UI.login();
        Passwords.user_password = (String) input.next();
        System.out.println("Okay, your password have been saved!");

        //Main menu
        UI.options(); //prints out options
        int option = input.nextInt();

        while (option != 0) {
            if (option == 1) {
                Randomly.make_password();
            } else if (option == 2) {
               Memorable.make_password();
            }else if (option ==3){
                Check.result();
            }
            else if (option == 4) {
               Passwords.show();
            }
                //redoes the whole thing
                System.out.printf("\n", "You can continue using the app.");
                UI.options();
                option = input.nextInt();

        }
    }
}