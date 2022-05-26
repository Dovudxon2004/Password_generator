package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Check {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Character> chars= new ArrayList<Character>();
    static Integer[] speciall_list = {33, 35, 36, 37, 38, 42, 63, 64, 95};
    static ArrayList<Integer> special_list = new ArrayList<>(Arrays.asList(speciall_list));
    static int number = 0, l_case = 0, u_case = 0, special = 0;


    public static String check_password(String password){
       //copying password to chars
        for (int i=0; i<password.length(); i++){
           char currentCharacter = password.charAt(i);
           chars.add(currentCharacter);
        }

        //count the number of letters, special_characters, and numbers
        for (int i=0; i< chars.size(); i++){
            if (special_list.contains((int)chars.get(i))){
                special ++;
            }
            else if ((int)chars.get(i) > 47 && (int)chars.get(i) < 58){
                number ++;
            }
            else if ((int)chars.get(i) > 64 && (int)chars.get(i) < 91){
                u_case ++;
            }
            else if ((int)chars.get(i) > 96 && (int)chars.get(i) < 123){
                l_case ++;
            }
        }
        ArrayList<Character> chars_copy = new ArrayList<>(chars);
        chars.removeAll(chars);

        if ((chars_copy.size() > 10 && special*number*u_case*l_case > 0) || chars_copy.size() >12){
            return "hard";
        }
        else if ((chars_copy.size() >= 6 && (number*u_case > 0 || number*l_case >0)) || chars_copy.size() > 8){
            return "medium";
        }
        else if ((chars_copy.size() > 4 && special*number*u_case*l_case > 0)){
            return "medium";
        }
        else{
            return "easy";
        }

    }
    public static void result(){
        System.out.println("Enter a password to check");
        String password_to_check = input.next();
        System.out.print("The difficulty of your password is " +  Check.check_password(password_to_check));
    }
}
