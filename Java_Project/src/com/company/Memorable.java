package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Memorable {
    static Scanner input = new Scanner(System.in);
    public static int year = 0;
    public static String name="", medium_pas="", hard_pas="", easy_pas="";
    ;

    // Generating an easy password
    public static String Easy_pas() {
        Memorable.easy_pas = name + year;
        String easy_pas_copy = easy_pas;
        easy_pas = "";
        return easy_pas_copy;
    }

    // Generating a medium password
    public static String Medium_pas() {
        ArrayList<String> symbols = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            char currentCharacter = name.charAt(i);
            symbols.add(String.valueOf(currentCharacter));
        }
        for (int i = 0; i < name.length(); i++) {
            medium_pas += symbols.get(i);
            if (i == name.length() / 2 - 1) {
                medium_pas += year;
            }
        }
        String medium_pas_copy = medium_pas;
        medium_pas = "";
        return medium_pas_copy;

    }

    // Generating hard password
    public static String Hard_pas() {
        ArrayList<String> symbols = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            char currentCharacter = name.charAt(i);
            symbols.add(String.valueOf(currentCharacter));
        }

        // In order to make the password more difficult, some letters are replaced with special characters and numbers
        for (int i = 0; i < symbols.size(); i++) {
            // Upper and lower case "s" are replaced with a dollar sign
            if (symbols.get(i).equals("S") || symbols.get(i).equals("s")) {
                symbols.set(i, "$");
            }
            // Upper and lower case "o" are replaced with a zero
            else if (symbols.get(i).equals("o") || symbols.get(i).equals("O")) {
                symbols.set(i, "0");
            }

            // Upper and lower case "i" are replaced with an exclamation mark
            else if (symbols.get(i).equals("i") || symbols.get(i).equals("I")) {
                symbols.set(i, "!");
            }
        }

        // Description
        for (int i = 0; i < name.length(); i++) {
            hard_pas += symbols.get(i);
            if (i == name.length() / 2 - 1) {
                hard_pas += "%";
                hard_pas += year;
            }
        }
        String hard_pas_copy = hard_pas;
        hard_pas = "";
        return hard_pas_copy;
    }

    // a method that displays all three passwords
    public static void showPas() {
        System.out.println("1. " + Easy_pas());
        System.out.println("2. " + Medium_pas());
        System.out.println("3. " + Hard_pas());
    }

    public static void make_password() {
        //Personal password
        System.out.println("If you want to generate a password based on your personal information, please follow the instructions below");

        //Getting the info
        System.out.print("Enter your name: ");
        Memorable.name = input.next();
        System.out.print("Enter the year of your birth: ");
        Memorable.year = input.nextInt();
        System.out.println("Here are your passwords: ");
        Memorable.showPas();
        System.out.println("Choose any of the above: (1/2/3)");

        int opt = input.nextInt();
        if (opt == 1) {
            //Easy personal password
            Passwords.add(2, Memorable.Easy_pas());
            System.out.println("Saved to 'My passwords'!");
        } else if (opt == 2) {
            //medium personal password
            Passwords.add(2, Memorable.Medium_pas());
            System.out.println("Saved to 'My passwords'!");
        } else if (opt == 3) {
            //hard personal password
            Passwords.add(2, Memorable.Hard_pas());
            System.out.println("Saved to 'My passwords'!");
        }

    }
}