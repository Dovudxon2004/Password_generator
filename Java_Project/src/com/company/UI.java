package com.company;

import java.util.Scanner;

public class UI {

    public static void login(){
        //Login

        System.out.println("Please come up with a password in order to continue!");
        System.out.print("\nPassword: "); // Password for a single session

    }

    public static void options(){
        System.out.println("Please choose any option below: (1/2/3/0)");
        System.out.println("1. Generate a random password");
        System.out.println("2. Generate an easy-to-remember password");
        System.out.println("3. Check the difficulty level of your password");
        System.out.println("4. My passwords");
        System.out.println("0. Quit");

    }
}
