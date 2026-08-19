// Base class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// First derived class
class Mammal extends Animal {
    void walk() {
        System.out.println("Mammal is walking");
    }
}

// Second derived class
class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Third derived class
class Puppy extends Dog {
    void play() {
        System.out.println("Puppy is playing");
    }
}

public class MultiLevelInheritance {
    public static void main(String[] args) {
        Puppy p = new Puppy();

      
        p.eat();  
        p.walk(); 
        p.bark(); 
        p.play();  
    }
}
