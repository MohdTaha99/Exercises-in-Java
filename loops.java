//a. Create a method that takes in a whole number as an argument, then it prints
//a triangle made of stars (*) into the console as high as the number put in as
//an argument;

public class StarTriangle {
    public static void printStarTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printStarTriangle(3);
    }
}


//Print all numbers up to user input;
//a. Write a method that will take a number from the user and print all the numbers
//starting from zero up to the user specified number.

import java.util.Scanner;

public class PrintNumbers {
    public static void printNumbersUpTo(int number) {
        for (int i = 0; i <= number; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();
        printNumbersUpTo(userInput);
        scanner.close();
    }
}


// Summing numbers up to user input;
//a. Write a method that will sum up all the numbers up to specified by the user
//and print out the result.

import java.util.Scanner;

public class SumNumbers {
    public static int sumNumbersUpTo(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();
        int result = sumNumbersUpTo(userInput);
        System.out.println("The sum of all numbers up to " + userInput + " is: " + result);
        scanner.close();
    }
}


//Calculate factorial of a number;
//a. Write a method that will take a whole number larger than zero (prepare
//appropriate checks for that), calculate its factorial and return it. For example
//for number 5, the result should be 120.

import java.util.Scanner;

public class FactorialCalculator {

    public static int calculateFactorial(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be larger than zero.");
        }

        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a whole number larger than zero: ");
        int userInput = scanner.nextInt();

        if (userInput > 0) {
            int result = calculateFactorial(userInput);
            System.out.println("The factorial of " + userInput + " is: " + result);
        } else {
            System.out.println("Invalid input. Please enter a number larger than zero.");
        }

        scanner.close();
    }
}

// Its Output:
//Enter a whole number larger than zero: 5
//The factorial of 5 is: 120


//Palindrome:
//a. Write a method that will check if a String is a palindrome (meaning it can be
//read the same from the front and back). Return true if it is a palindrome, false
//if not.

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        boolean result = isPalindrome(userInput);
        if (result) {
            System.out.println("\"" + userInput + "\" is a palindrome.");
        } else {
            System.out.println("\"" + userInput + "\" is not a palindrome.");
        }

        scanner.close();
    }
}

//Its Output:
//Enter a string: racecar
//"racecar" is a palindrome.


//Calculator
//a. Create a Calculator class using the skeleton provided below;
//b. The code will get from user 3 values:
//i. first number;
//ii. second number;
//iii. operation to be executed between them (+, -, *, /);
//c. Additionally user can input an exit command that will finish the program;
//d. At the beginning, show user what operations are supported. Inform the user
//to try again if wrong operation is put in;
//e. Make sure all math operations are possible (for example no dividing by zero)!
//f. Use String.equals method to compare the operations you get from the user.
//Below you can find the class skeleton, copy it over and fill with your implementation.
//The program should be started by creating a Calculator object and running start()
//method

import java.util.Scanner;

public class Calculator {

    private Scanner scanner;

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Calculator!");
        System.out.println("Supported operations: +, -, *, /");
        System.out.println("Type 'exit' to finish the program.");

        while (true) {
            System.out.print("Enter first number: ");
            int num1 = getNumberFromUser();
            System.out.print("Enter second number: ");
            int num2 = getNumberFromUser();
            System.out.print("Enter operation (+, -, *, /): ");
            String operation = getOperationFromUser();

            if (operation.equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            int result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = divide(num1, num2);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Error: Unsupported operation. Please try again.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
    }

    private String getOperationFromUser() {
        return scanner.next();
    }

    private int getNumberFromUser() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number:");
            scanner.next(); // Discard invalid input
        }
        return scanner.nextInt();
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int divide(int a, int b) {
        return a / b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
