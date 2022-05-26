package com.company;
import java.util.Random;
import java.util.Scanner;

public class Randomly {
    static Scanner input = new Scanner(System.in);
    static int[] special = {33, 35, 36, 37, 38, 42, 63, 64};
    public static String password_generator(int length, int type) {
        Random rand = new Random();
        char array[] = new char[length];

        if (type == 3) {
            //gives hard password
            for (int i = 0; i < (length / 4); i++) {
                int r = rand.nextInt(65, 91);
                array[i] = (char) r;
            }

            for (int i = (length / 4); i <  (length / 2); i++) {
                int r = rand.nextInt(97, 123);
                array[i] = (char) r;
            }

            for (int i =  (length / 2); i <  (5 * length / 8); i++) {
                int r = rand.nextInt(special.length);
                array[i] = (char) special[r];
            }

            for (int i = (5 * length / 8); i < length; i++) {
                int r = rand.nextInt(48, 58);
                array[i] = (char) r;
            }
        } else if (type == 2) {
            //give medium password
            for (int i = 0; i <  (length / 4); i++) {
                int r = rand.nextInt(65, 91);
                array[i] = (char) r;

            }
            for (int i =  (length / 4); i < (length / 2); i++) {
                int r = rand.nextInt(97, 123);
                array[i] = (char) r;

            }
            for (int i = (length / 2); i < length; i++) {
                int r = rand.nextInt(48, 58);
                array[i] = (char) r;

            }

        } else if (type == 1) {
            //gives easy password
            int choice = rand.nextInt(1, 3);

            if (choice == 1) {
                //gives easy password with numbers and lower case letters
                for (int i = 0; i <  (length / 2); i++) {
                    int r = rand.nextInt(97, 123);
                    array[i] = (char) r;
                }
                for (int i = (length / 2); i < length; i++) {
                    int r = rand.nextInt(48, 58);
                    array[i] = (char) r;
                }
            } else {
                //gives easy password with numbers and upper case letters
                for (int i = 0; i <  (length / 2); i++) {
                    int r = rand.nextInt(65, 91);
                    array[i] = (char) r;
                }
                for (int i = (length / 2); i < length; i++) {
                    int r = rand.nextInt(48, 58);
                    array[i] = (char) r;
                }
            }
        }

        String str = "";
        int i = 0;
        while (i < length) {
            int r = rand.nextInt(length);
            if ((int) array[r] != (int) '+') {
                str += array[r];
                array[r] = '+';
                i++;
            }
        }
        return str;
    }

    public static void make_password() {
        //Random password

        //Asking for length and type
        System.out.println("How many characters should there be?");
        int length = input.nextInt();

        System.out.println("What should be the difficulty level of the password?");
        System.out.println("Enter 1 for easy, 2 for medium, 3 for hard");
        int type = input.nextInt();

        //Generate the password
        String random_password = Randomly.password_generator(length, type);
        System.out.println(random_password);

        //Add the password to the list
        Passwords.add(1, random_password);
        System.out.println("Password added to 'My Passwords!'");
    }
}
