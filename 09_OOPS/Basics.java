public class Basics {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone(); // s1 is a reference variable
        s1.name = "Samsung M12";
        s1.price = 20000;
        s1.brand = "Samsung";

        s1.displayDetails();

        SmartPhone s2 = new SmartPhone();
        s2.name = "Samsung M14";
        s2.price = 20000;
        s2.brand = "Samsung";

        s1.makeCall(s2);
    }
}

class SmartPhone {
    // properties (attributes)
    String name;
    double price;
    String brand;

    // methods (behaviour)
    void makeCall(SmartPhone other) {
        System.out.println("Calling " + other.name);
    }

    void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}