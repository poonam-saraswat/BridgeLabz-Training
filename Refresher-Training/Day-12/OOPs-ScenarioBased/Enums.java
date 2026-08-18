public enum Season {
    WINTER("Cold"),
    SPRING("Mild"),
    SUMMER("Hot"),
    FALL("Cool");

    private final String description;

    // Constructor for enum
    Season(String description) {
        this.description = description;
    }

    // Getter method
    public String getDescription() {
        return description;
    }
}

public class Enums {
    public static void main(String[] args) {
        // Loop through all enum values
        for (Season s : Season.values()) {
            System.out.println(s.name() + " : " + s.getDescription());
        }

        // Example switch statement
        Season current = Season.SUMMER;

        switch (current) {
            case SUMMER:
                System.out.println("It's hot! Time for ice cream.");
                break;
            default:
                System.out.println("Not summer — enjoy the season!");
        }
    }
}
