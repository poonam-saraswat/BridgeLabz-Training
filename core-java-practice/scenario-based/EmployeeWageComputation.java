import java.util.Random;

public class EmployeeWageComputation {

    // Constants
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;
    public static final int WORKING_DAYS_PER_MONTH = 20;
    public static final int MAX_HOURS_IN_MONTH = 100;
    public static final int MAX_WORKING_DAYS = 20;

    // Attendance check (UC1)
    public static boolean isEmployeePresent() {
        Random random = new Random();
        int empCheck = random.nextInt(2); // 0 or 1
        return empCheck == 1;
    }

    // Wage calculation using switch-case (UC2, UC3, UC4)
    public static int getDailyWage(int empType) {
        int empHours = 0;
        switch (empType) {
            case 1: // Full-time
                empHours = FULL_DAY_HOUR;
                break;
            case 2: // Part-time
                empHours = PART_TIME_HOUR;
                break;
            default: // Absent
                empHours = 0;
        }
        return empHours * WAGE_PER_HOUR;
    }

    // Monthly wage calculation (UC5)
    public static int calculateMonthlyWage() {
        int totalWage = 0;
        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            int empType = new Random().nextInt(3); // 0=Absent, 1=Full-time, 2=Part-time
            int dailyWage = getDailyWage(empType);
            totalWage += dailyWage;
            System.out.println("Day " + day + " Wage: " + dailyWage);
        }
        return totalWage;
    }

    // Wage till condition (UC6)
    public static int calculateWageTillCondition() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < MAX_HOURS_IN_MONTH && totalDays < MAX_WORKING_DAYS) {
            totalDays++;
            int empType = new Random().nextInt(3);
            int empHours = 0;

            switch (empType) {
                case 1: empHours = FULL_DAY_HOUR; break;
                case 2: empHours = PART_TIME_HOUR; break;
                default: empHours = 0;
            }

            totalHours += empHours;
            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWage += dailyWage;

            System.out.println("Day " + totalDays + " Hours: " + empHours + " Wage: " + dailyWage);
        }
        return totalWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program!");

        // UC1: Attendance
        if (isEmployeePresent()) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }

        // UC2–UC4: Daily wage with switch-case
        int dailyWage = getDailyWage(1); // Full-time example
        System.out.println("Daily Wage (Full-time): " + dailyWage);

        dailyWage = getDailyWage(2); // Part-time example
        System.out.println("Daily Wage (Part-time): " + dailyWage);

        // UC5: Monthly wage
        int monthlyWage = calculateMonthlyWage();
        System.out.println("Total Monthly Wage: " + monthlyWage);

        // UC6: Wage till condition
        int conditionalWage = calculateWageTillCondition();
        System.out.println("Total Wage till condition: " + conditionalWage);
    }
}