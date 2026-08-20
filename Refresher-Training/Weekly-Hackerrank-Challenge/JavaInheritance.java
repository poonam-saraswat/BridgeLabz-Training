import java.io.*;

// Base class
class Animal {
    void walk() {
        System.out.println("I am walking");
    }
    void run() {
        System.out.println("I am running");
    }
}

// Subclass Bird extends Animal
class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }
    void sing() {
        System.out.println("I am singing");
    }
}

public class JavaInheritance {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();   // inherited from Animal
        bird.run();    // inherited from Animal
        bird.fly();    // defined in Bird
        bird.sing();   // newly added method
    }
}
