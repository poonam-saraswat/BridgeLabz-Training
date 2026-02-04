package annotations;

// Parent class
class Animal {
    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {
    // Overriding the makeSound() method
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        // Instantiate Dog and call makeSound()
        Dog myDog = new Dog();
        myDog.makeSound();  // Output: Dog barks
    }
}