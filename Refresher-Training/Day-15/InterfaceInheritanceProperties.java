interface Animal {
    // Constant field (implicitly public static final)
    int MAX_AGE = 20;

    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void play() {
        // Accessing the constant directly
        System.out.println("Playing, max age is " + MAX_AGE);
    }

    public void showConstant() {
        // Accessing via interface name
        System.out.println("Animal.MAX_AGE = " + Animal.MAX_AGE);
    }
}

public class InterfaceInheritanceProperties {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
        d.showConstant();
    }
}
