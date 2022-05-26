package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Passwords {
    static Scanner input = new Scanner(System.in);
    static String user_password;
    static ArrayList<String> random_passwords = new ArrayList<>();
    static ArrayList<String> personal_passwords = new ArrayList<>();

    public static void add(int type, String password){
        if (type ==1){
            random_passwords.add(password);
        }
        else{
            personal_passwords.add(password);
        }
    }
    public static boolean authenticate(String password){

        if (user_password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void give(){
        if (random_passwords.size()==0){
            System.out.println("You don't have randomly generated passwords");
        }
        else {
            System.out.println("Randomly generated passwords for you: ");
            for (int i = 0; i < random_passwords.size(); i++) {
                System.out.println(i + 1 + random_passwords.get(i));
            }
        }
        if (personal_passwords.size() == 0){
            System.out.println("You don't have easy-to-remember passwords");
        }
        else {
            System.out.println("Your easy-to-remember passwords:");
            for (int i = 0; i < personal_passwords.size(); i++) {
                System.out.println(i + 1 + personal_passwords.get(i));
            }
        }
    }

    public static void show(){
        System.out.println("In order to view your passwords, please confirm your identity!");

        //Getting the password
        System.out.print("Please enter your password: ");
        String password = (String) input.next();
        while (true) {

            //shows if the password is correct
            if (Passwords.authenticate(password)) {
                Passwords.give();
                break;
            }
            else if (password.equals("quit")){
                break;
            }
            else{
                //asks again if the password is incorrect
                System.out.println("Your password is incorrect!");
                System.out.println("Try again or enter \"quit\" to quit");
                password = (String)input.next();
            }
        }
    }
}
