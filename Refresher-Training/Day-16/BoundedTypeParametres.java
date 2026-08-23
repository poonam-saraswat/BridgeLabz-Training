import java.util.*;

class NumericBox<T extends Number> {
    private T value;

    public NumericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class BoundedTypeParametres {

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
       
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Sum of Integer list: " + sumOfList(intList));
        System.out.println("Sum of Double list: " + sumOfList(doubleList));

    
        NumericBox<Integer> box1 = new NumericBox<>(10);
        NumericBox<Double> box2 = new NumericBox<>(12.5);

        System.out.println("NumericBox int value: " + box1.getValue());
        System.out.println("NumericBox double value: " + box2.getValue());
    }
}
