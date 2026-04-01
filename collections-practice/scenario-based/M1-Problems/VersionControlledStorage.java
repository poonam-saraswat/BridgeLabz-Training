package M1-Problems;

import java.util.*;

class FileVersion {
    String version;
    int size;
    long uploadOrder; // to track latest upload

    FileVersion(String version, int size, long uploadOrder) {
        this.version = version;
        this.size = size;
        this.uploadOrder = uploadOrder;
    }
}

public class VersionControlledStorage {
    private static Map<String, List<FileVersion>> storage = new HashMap<>();
    private static long orderCounter = 0; // increments with each upload

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String command = parts[0];

            switch (command) {
                case "UPLOAD":
                    handleUpload(parts);
                    break;
                case "FETCH":
                    handleFetch(parts[1]);
                    break;
                case "LATEST":
                    handleLatest(parts[1]);
                    break;
                case "TOTAL_STORAGE":
                    handleTotalStorage(parts[1]);
                    break;
            }
        }
        sc.close();
    }

    private static void handleUpload(String[] parts) {
        String fileName = parts[1];
        String version = parts[2];
        int size = Integer.parseInt(parts[3]);

        storage.putIfAbsent(fileName, new ArrayList<>());
        List<FileVersion> versions = storage.get(fileName);

        // Ignore if version already exists
        for (FileVersion fv : versions) {
            if (fv.version.equals(version)) return;
        }

        versions.add(new FileVersion(version, size, ++orderCounter));
    }

    private static void handleFetch(String fileName) {
        if (!storage.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        List<FileVersion> versions = storage.get(fileName);
        versions.stream()
                .sorted((a, b) -> {
                    if (a.size != b.size) return Integer.compare(a.size, b.size);
                    return a.version.compareTo(b.version);
                })
                .forEach(v -> System.out.println(fileName + " " + v.version + " " + v.size));
    }

    private static void handleLatest(String fileName) {
        if (!storage.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        List<FileVersion> versions = storage.get(fileName);
        FileVersion latest = versions.stream()
                .max(Comparator.comparingLong(v -> v.uploadOrder))
                .orElse(null);

        if (latest != null) {
            System.out.println(fileName + " " + latest.version + " " + latest.size);
        }
    }

    private static void handleTotalStorage(String fileName) {
        if (!storage.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        int total = storage.get(fileName).stream().mapToInt(v -> v.size).sum();
        System.out.println(fileName + " " + total);
    }
}