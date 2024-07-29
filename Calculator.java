//Simple calculator
//a. Create a class with two methods: add and subtract that will take two numbers
//and return their sum or their difference;
//b. Try to use the outcomes of those methods as arguments, for example add up
//two numbers and use the sum to subtract it from another number;

public class Calculator {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Using add and subtract methods
        int sum = calculator.add(10, 5); // 10 + 5 = 15
        int difference = calculator.subtract(sum, 3); // 15 - 3 = 12

        // Printing the results
        System.out.println("Sum: " + sum); // Sum: 15
        System.out.println("Difference: " + difference); // Difference: 12
    }
}

// 3 numbers average
//a. Write a method that gets 3 numbers from the user, then calculate average of
//the 3 numbers and return it to the user;
//b. Call the function in main and print out the value that you get;

import java.util.Scanner;

public class AverageCalculator {
    // Method to calculate the average of three numbers
    public static double calculateAverage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = scanner.nextDouble();

        double average = (num1 + num2 + num3) / 3;
        return average;
    }

    public static void main(String[] args) {
        // Calculate the average and print the result
        double average = calculateAverage();
        System.out.println("The average of the three numbers is: " + average);
    }
}
