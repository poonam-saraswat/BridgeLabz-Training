import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // HashMap to store votes (Candidate -> Votes)
        Map<String, Integer> voteMap = new HashMap<>();

        System.out.print("Enter number of votes to cast: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // LinkedHashMap to maintain order of votes cast
        Map<Integer, String> voteOrder = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter candidate name for vote " + i + ": ");
            String candidate = scanner.nextLine();

            // Store vote in HashMap
            voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

            // Maintain order of votes in LinkedHashMap
            voteOrder.put(i, candidate);
        }

        // Display votes in insertion order (LinkedHashMap)
        System.out.println("\nOrder of votes cast:");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote " + entry.getKey() + " -> " + entry.getValue());
        }

        // Display results in sorted order (TreeMap)
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteMap);

        System.out.println("\nFinal Results (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        scanner.close();
    }
}