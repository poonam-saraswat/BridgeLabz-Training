import java.util.ArrayList;
import java.util.List;

// Base interface for all meal plans
interface MealPlan {
    String getMealType();
    boolean isValid(); // validation rule for each meal plan
}

// Vegetarian meal
class VegetarianMeal implements MealPlan {
    private String dish;

    public VegetarianMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public String getMealType() {
        return "Vegetarian Meal: " + dish;
    }

    @Override
    public boolean isValid() {
        // Example validation: vegetarian meals should not contain meat
        return !dish.toLowerCase().contains("chicken") && !dish.toLowerCase().contains("meat");
    }
}

// Vegan meal
class VeganMeal implements MealPlan {
    private String dish;

    public VeganMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public String getMealType() {
        return "Vegan Meal: " + dish;
    }

    @Override
    public boolean isValid() {
        // Example validation: vegan meals should not contain dairy or eggs
        return !dish.toLowerCase().contains("milk") && !dish.toLowerCase().contains("egg");
    }
}

// Keto meal
class KetoMeal implements MealPlan {
    private String dish;

    public KetoMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public String getMealType() {
        return "Keto Meal: " + dish;
    }

    @Override
    public boolean isValid() {
        // Example validation: keto meals should be low-carb
        return !dish.toLowerCase().contains("bread") && !dish.toLowerCase().contains("rice");
    }
}

// High-Protein meal
class HighProteinMeal implements MealPlan {
    private String dish;

    public HighProteinMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public String getMealType() {
        return "High-Protein Meal: " + dish;
    }

    @Override
    public boolean isValid() {
        // Example validation: must contain protein keyword
        return dish.toLowerCase().contains("protein") || dish.toLowerCase().contains("egg") || dish.toLowerCase().contains("chicken");
    }
}

// Generic Meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Utility class with generic method
class MealPlanGenerator {
    // Generic method to validate and generate meal plan
    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        if (mealPlan.isValid()) {
            System.out.println("Meal Plan Generated Successfully: " + mealPlan.getMealType());
        } else {
            System.out.println("Invalid Meal Plan: " + mealPlan.getMealType());
        }
    }

    // Display all meal plans
    public static void displayAllPlans(List<? extends MealPlan> plans) {
        for (MealPlan plan : plans) {
            System.out.println(plan.getMealType() + " | Valid: " + plan.isValid());
        }
    }
}

// Demo class
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        List<MealPlan> plans = new ArrayList<>();

        VegetarianMeal vegMeal = new VegetarianMeal("Paneer Curry");
        VeganMeal veganMeal = new VeganMeal("Soy Milk Smoothie");
        KetoMeal ketoMeal = new KetoMeal("Grilled Chicken with Salad");
        HighProteinMeal proteinMeal = new HighProteinMeal("Protein Shake");

        plans.add(vegMeal);
        plans.add(veganMeal);
        plans.add(ketoMeal);
        plans.add(proteinMeal);

        // Generate personalized meal plans
        System.out.println("=== Generating Meal Plans ===");
        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(proteinMeal);

        // Display all plans
        System.out.println("\n=== All Meal Plans ===");
        MealPlanGenerator.displayAllPlans(plans);
    }
}