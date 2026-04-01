import java.util.*;
import java.text.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return policyNumber.equals(p.policyNumber); // uniqueness by policy number
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate); // TreeSet sorts by expiry date
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("Policy[%s, %s, Expiry=%s, Coverage=%s, Premium=%.2f]",
                policyNumber, policyholderName, sdf.format(expiryDate), coverageType, premiumAmount);
    }
}

public class InsurancePolicyManagement {
    private static Set<Policy> hashSet = new HashSet<>();
    private static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private static Set<Policy> treeSet = new TreeSet<>();

    // Add policy to all sets
    public static void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    // Retrieve all unique policies
    public static void displayAllPolicies() {
        System.out.println("\n--- All Unique Policies (HashSet) ---");
        for (Policy p : hashSet) System.out.println(p);
    }

    // Policies expiring within next 30 days
    public static void displayExpiringSoon() {
        System.out.println("\n--- Policies Expiring Soon (within 30 days) ---");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date limit = cal.getTime();

        for (Policy p : treeSet) {
            if (p.getExpiryDate().after(now) && p.getExpiryDate().before(limit)) {
                System.out.println(p);
            }
        }
    }

    // Policies with specific coverage type
    public static void displayByCoverage(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Detect duplicates based on policy number
    public static void displayDuplicates(List<Policy> policies) {
        System.out.println("\n--- Duplicate Policies ---");
        Set<String> seen = new HashSet<>();
        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                System.out.println(p);
            }
        }
    }

    // Performance comparison
    public static void performanceTest() {
        System.out.println("\n--- Performance Comparison ---");
        List<Policy> testData = new ArrayList<>(hashSet);

        long start, end;

        // HashSet add
        Set<Policy> hs = new HashSet<>();
        start = System.nanoTime();
        for (Policy p : testData) hs.add(p);
        end = System.nanoTime();
        System.out.println("HashSet add time: " + (end - start) + " ns");

        // LinkedHashSet add
        Set<Policy> lhs = new LinkedHashSet<>();
        start = System.nanoTime();
        for (Policy p : testData) lhs.add(p);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start) + " ns");

        // TreeSet add
        Set<Policy> ts = new TreeSet<>();
        start = System.nanoTime();
        for (Policy p : testData) ts.add(p);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start) + " ns");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Policy> inputPolicies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Policy " + (i+1));
            System.out.print("Policy Number: ");
            String num = sc.nextLine();
            System.out.print("Policyholder Name: ");
            String name = sc.nextLine();
            System.out.print("Expiry Date (dd-MM-yyyy): ");
            Date expiry = sdf.parse(sc.nextLine());
            System.out.print("Coverage Type (Health/Auto/Home): ");
            String type = sc.nextLine();
            System.out.print("Premium Amount: ");
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy p = new Policy(num, name, expiry, type, premium);
            addPolicy(p);
            inputPolicies.add(p);
        }

        // Display results
        displayAllPolicies();
        displayExpiringSoon();
        displayByCoverage("Health");
        displayDuplicates(inputPolicies);
        performanceTest();

        sc.close();
    }
}