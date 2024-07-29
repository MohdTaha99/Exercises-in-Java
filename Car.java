//exercise 1
public class Car {
    public int weight;
    public String manufacturer;
    public String model;

    // Constructor
    public Car(int weight, String manufacturer, String model) {
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void print() {
        System.out.println("Gaadi ki Tafseel:");
        System.out.println("Wazan: " + this.weight);
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Model: " + this.model);
    }

    public static void main(String[] args) {
        // Using Constructor to make objects
        Car car1 = new Car(1500, "Toyota", "Corolla");
        Car car2 = new Car(1800, "Honda", "Civic");
        Car car3 = new Car(2000, "Ford", "Mustang");

        // Print the information about the car
        car1.print();
        car2.print();
        car3.print();
    }
}

//exercise 2
public class Car {
    private int weight;
    private String manufacturer;
    private String model;

    // Constructor
    public Car(int weight, String manufacturer, String model) {
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void print() {
        System.out.println("Gaadi ki Tafseel:");
        System.out.println("Wazan: " + this.weight);
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Model: " + this.model);
    }

    public static void main(String[] args) {
        // Using Constructor to make new objects
        Car car1 = new Car(1500, "Toyota", "Corolla");
        Car car2 = new Car(1800, "Honda", "Civic");
        Car car3 = new Car(2000, "Ford", "Mustang");

        // Print the information about Car
        car1.print();
        car2.print();
        car3.print();
    }
}


