//Create a method that will gather 3 numbers from the user to an array and return the
//average of those numbers;

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


//TodoList: Create a TodoList class, which uses an array to store tasks in the form of
//Strings. The list should be created within a constructor, which should get the size of
//the array as an argument. The methods should be:
//a. public void add(String task) - Add a task to the array;
//b. public void print() - Print out all tasks with their index;
//c. public void remove(int number) - Remove a task from the list.
//3. Bonus: Modify the TodoList in a way that if the initial capacity is exceeded, a new
//array is created and old data is copied, so that it can expand

public class TodoList {
    private String[] tasks;
    private int count;

    public TodoList(int initialCapacity) {
        tasks = new String[initialCapacity];
        count = 0;
    }

    public void add(String task) {
        if (count == tasks.length) {
            expandArray();
        }
        tasks[count] = task;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + tasks[i]);
        }
    }

    public void remove(int number) {
        if (number < 0 || number >= count) {
            System.out.println("Invalid task number.");
            return;
        }
        for (int i = number; i < count - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[count - 1] = null;
        count--;
    }

    private void expandArray() {
        String[] newTasks = new String[tasks.length * 2];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        tasks = newTasks;
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList(3);
        todoList.add("Buy groceries");
        todoList.add("Read a book");
        todoList.add("Go for a walk");
        todoList.add("Write code");

        System.out.println("Todo List:");
        todoList.print();

        todoList.remove(2);
        System.out.println("Todo List after removing task 2:");
        todoList.print();
    }
}

//Add the history function to the Calculator exercise from the previous module. The
//calculator should have an ArrayList field that stores Strings. Every equation should
//be saved in the form of “number1 (operation sign) number 2 = result”, At the end of
//the program, print out all the equations that were done.

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    private Scanner scanner;
    private ArrayList<String> history;

    public Calculator() {
        scanner = new Scanner(System.in);
        history = new ArrayList<>();
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
            String equation = "";

            switch (operation) {
                case "+":
                    result = add(num1, num2);
                    equation = num1 + " + " + num2 + " = " + result;
                    break;
                case "-":
                    result = subtract(num1, num2);
                    equation = num1 + " - " + num2 + " = " + result;
                    break;
                case "*":
                    result = multiply(num1, num2);
                    equation = num1 + " * " + num2 + " = " + result;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = divide(num1, num2);
                        equation = num1 + " / " + num2 + " = " + result;
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
                history.add(equation);
                System.out.println("Result: " + result);
            }
        }

        printHistory();
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

    private void printHistory() {
        System.out.println("Calculation History:");
        for (String equation : history) {
            System.out.println(equation);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}


// Sorting a list: Create a Student class that implements a Comparable interface. The
//fields of Student class:
//a. int age;
//b. String name;
//c. String lastName.
//Sort by name first, then by age.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Student implements Comparable<Student> {
    private int age;
    private String name;
    private String lastName;

    public Student(int age, String name, String lastName) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, lastName);
    }

    @Override
    public int compareTo(Student other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(20, "Alice", "Smith"));
        students.add(new Student(22, "Bob", "Brown"));
        students.add(new Student(20, "Alice", "Johnson"));
        students.add(new Student(21, "Charlie", "Davis"));

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students);

        System.out.println("\nAfter sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

//Counting words in a text: Write a method that will get String as an input and will
//return a HashMap with the word as a key and the number of occurrences as a value:
//d. public HashMap<String, Integer> countWords(String text)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        HashMap<String, Integer> wordCount = countWords(text);
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}


//Library: Create a Library class which will allow the user to save an author and the
//list of books of said author. The user should be able to add an author and add the
//books. Books should be sorted by the number of pages.
//Classes:
//Author
//name;
//age;
//favouriteGenre;
//Book
//title;
//genre;
//numberOfPages;
//Library
//getBooksOfAuthor(String authorName)
//addBookToAuthor(String authorName, Book book)
//getAllAuthors()
//getAllBooks();
//getAllBooksAndAuthors();
//addAuthor(Author author);

import java.util.*;

class Author {
    private String name;
    private int age;
    private String favouriteGenre;

    public Author(String name, int age, String favouriteGenre) {
        this.name = name;
        this.age = age;
        this.favouriteGenre = favouriteGenre;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{name='" + name + "', age=" + age + ", favouriteGenre='" + favouriteGenre + "'}";
    }
}

class Book implements Comparable<Book> {
    private String title;
    private String genre;
    private int numberOfPages;

    public Book(String title, String genre, int numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.numberOfPages, other.numberOfPages);
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', genre='" + genre + "', numberOfPages=" + numberOfPages + "}";
    }
}

class Library {
    private HashMap<Author, ArrayList<Book>> library;

    public Library() {
        library = new HashMap<>();
    }

    public void addAuthor(Author author) {
        library.putIfAbsent(author, new ArrayList<>());
    }

    public void addBookToAuthor(String authorName, Book book) {
        for (Author author : library.keySet()) {
            if (author.getName().equals(authorName)) {
                library.get(author).add(book);
                Collections.sort(library.get(author));
                return;
            }
        }
        System.out.println("Author not found.");
    }

    public List<Book> getBooksOfAuthor(String authorName) {
        for (Author author : library.keySet()) {
            if (author.getName().equals(authorName)) {
                return library.get(author);
            }
        }
        return Collections.emptyList();
    }

    public Set<Author> getAllAuthors() {
        return library.keySet();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        for (List<Book> books : library.values()) {
            allBooks.addAll(books);
        }
        return allBooks;
    }

    public Map<Author, List<Book>> getAllBooksAndAuthors() {
        return Collections.unmodifiableMap(library);
    }

    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("John Doe", 45, "Fantasy");
        Author author2 = new Author("Jane Smith", 38, "Science Fiction");

        library.addAuthor(author1);
        library.addAuthor(author2);

        library.addBookToAuthor("John Doe", new Book("The Magic World", "Fantasy", 300));
        library.addBookToAuthor("John Doe", new Book("Another World", "Fantasy", 150));
        library.addBookToAuthor("Jane Smith", new Book("Future Stories", "Science Fiction", 200));

        System.out.println("All Authors:");
        for (Author author : library.getAllAuthors()) {
            System.out.println(author);
        }

        System.out.println("\nBooks of John Doe:");
        for (Book book : library.getBooksOfAuthor("John Doe")) {
            System.out.println(book);
        }

        System.out.println("\nAll Books:");
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\nAll Books and Authors:");
        for (Map.Entry<Author, List<Book>> entry : library.getAllBooksAndAuthors().entrySet()) {
            System.out.println("Author: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  Book: " + book);
            }
        }
    }
}



