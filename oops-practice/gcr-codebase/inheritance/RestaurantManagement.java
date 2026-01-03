// Worker interface
interface Worker {
    void performDuties();
}

// Superclass Person
class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Display basic info
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Subclass Chef inheriting Person and implementing Worker
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Chef) is cooking delicious meals.");
    }
}

// Subclass Waiter inheriting Person and implementing Worker
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Waiter) is serving customers.");
    }
}

// Main class to test the system
public class RestaurantManagement {
    public static void main(String[] args) {
        // Create objects
        Chef chef = new Chef("Arjun", 101);
        Waiter waiter = new Waiter("Ravi", 102);

        // Display info and perform duties
        chef.displayInfo();
        chef.performDuties();

        waiter.displayInfo();
        waiter.performDuties();
    }


}
     