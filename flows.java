//Arguments check
//a. Write a method, that will get a number from the user and print out whether this
//number is positive or negative;
import java.util.Scanner;

public class NumberChecker {
    // Method to check if the number is positive or negative
    public void checkNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of NumberChecker and call the checkNumber method
        NumberChecker numberChecker = new NumberChecker();
        numberChecker.checkNumber();
    }
}

//Password length checker
//a. Write a method that will ask a user for password and print out whether the
//password is longer than 8 characters and shorter than 12 characters;

import java.util.Scanner;

public class PasswordChecker {
    // Method to check the length of the password
    public void checkPasswordLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();

        if (length > 8 && length < 12) {
            System.out.println("The password length is between 8 and 12 characters.");
        } else {
            System.out.println("The password length is not between 8 and 12 characters.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of PasswordChecker and call the checkPasswordLength method
        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.checkPasswordLength();
    }
}

// Division of numbers
//a. Write a method that will take two numbers and only divide them if they’re
//larger than zero. If not, return zero.

import java.util.Scanner;

public class PasswordChecker {
    // Method to check the length of the password
    public void checkPasswordLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();

        if (length > 8 && length < 12) {
            System.out.println("The password length is between 8 and 12 characters.");
        } else {
            System.out.println("The password length is not between 8 and 12 characters.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of PasswordChecker and call the checkPasswordLength method
        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.checkPasswordLength();
    }
}

