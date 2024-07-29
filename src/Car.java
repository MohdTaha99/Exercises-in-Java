// exercise 1
public class Car {
    // Fields
    public int weight;
    public String manufacturer;
    public String model;

    // Constructor
    public Car(int weight, String manufacturer, String model) {
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // Method to print car details
    public void print() {
        System.out.println("Car Details:");
        System.out.println("Weight: " + this.weight);
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Model: " + this.model);
    }

    // Main method to create and print car objects
    public static void main(String[] args) {
        // Create three different car objects
        Car car1 = new Car(1500, "Toyota", "Corolla");
        Car car2 = new Car(1800, "Honda", "Civic");
        Car car3 = new Car(2000, "Ford", "Mustang");

        // Print the car objects using System.out.println
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        // Call the print method on all three car objects
        car1.print();
        car2.print();
        car3.print();
    }
}
