//1. Write tests to exercises from the last lesson about collections and add additional
//tests:
//a. Exercise 1:
//i. Check if adding up 1, 3, and 5 will return 9;
//ii. Check if the code behaves as expected for an array with negative
//numbers;

import java.util.Scanner;

public class AverageCalculator {

    public static void main(String[] args) {
        double average = getAverageOfThreeNumbers();
        System.out.println("The average of the three numbers is: " + average);
    }

    public static double getAverageOfThreeNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3]; // Create an array with a fixed size of 3

        // Loop to gather three numbers from the user
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = getNumberFromUser(scanner);
        }

        scanner.close();

        return calculateAverage(numbers);
    }

    // Overloaded method for testing purposes
    public static double getAverageOfThreeNumbers(int[] numbers) {
        return calculateAverage(numbers);
    }

    private static int getNumberFromUser(Scanner scanner) {
        // Loop to ensure valid input
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number:");
            scanner.next(); // Discard invalid input
        }
        return scanner.nextInt();
    }

    private static double calculateAverage(int[] numbers) {
        int sum = 0;
        // Loop to calculate the sum of the numbers
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageCalculatorTest {

    @Test
    public void testSumOfPositiveNumbers() {
        int sum = 1 + 3 + 5;
        assertEquals(9, sum, "The sum of 1, 3, and 5 should be 9");
    }

    @Test
    public void testSumOfNegativeNumbers() {
        int sum = -1 + -3 + -5;
        assertEquals(-9, sum, "The sum of -1, -3, and -5 should be -9");
    }
}


//Exercise 2:
//i. For the text “John has a cat, Joe has a dog” you should expect to get
//a map with values: “John, 1”, “Joe, 1”, “dog, 1”, “cat, 1”, “has, 2”, “a,
//2”;

import java.util.HashMap;

public class WordCounter {

    public static HashMap<String, Integer> countWords(String text) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Normalize words
            if (word.isEmpty()) {
                continue;
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testWordCount() {
        String text = "John has a cat, Joe has a dog";
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("john", 1);
        expected.put("has", 2);
        expected.put("a", 2);
        expected.put("cat", 1);
        expected.put("joe", 1);
        expected.put("dog", 1);

        HashMap<String, Integer> result = WordCounter.countWords(text);
        assertEquals(expected, result);
    }
}

