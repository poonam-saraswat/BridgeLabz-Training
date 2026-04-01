import java.util.*;

class Student {
    String name;
    int score;
    String district;

    public Student(String name, int score, String district) {
        this.name = name;
        this.score = score;
        this.district = district;
    }

    @Override
    public String toString() {
        return name + " (" + district + ") - " + score;
    }
}

public class EduResults {

    // Merge Sort implementation
    public static void mergeSort(List<Student> students) {
        if (students.size() <= 1) return;

        int mid = students.size() / 2;
        List<Student> left = new ArrayList<>(students.subList(0, mid));
        List<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        mergeSort(left);
        mergeSort(right);

        merge(students, left, right);
    }

    // Merge two sorted sublists
    private static void merge(List<Student> students, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            // Stable sorting: if scores are equal, preserve original order
            if (left.get(i).score >= right.get(j).score) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {
        // Example: Each district submits a sorted list
        List<Student> districtA = Arrays.asList(
                new Student("Amit", 95, "District A"),
                new Student("Ravi", 90, "District A"),
                new Student("Sneha", 85, "District A")
        );

        List<Student> districtB = Arrays.asList(
                new Student("Pooja", 98, "District B"),
                new Student("Karan", 92, "District B"),
                new Student("Meena", 88, "District B")
        );

        List<Student> districtC = Arrays.asList(
                new Student("Rahul", 97, "District C"),
                new Student("Neha", 91, "District C"),
                new Student("Vikas", 89, "District C")
        );

        // Combine all district lists
        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(districtA);
        allStudents.addAll(districtB);
        allStudents.addAll(districtC);

        // Apply Merge Sort to generate final rank list
        mergeSort(allStudents);

        // Print final state-wise rank list
        System.out.println("Final State-wise Rank List:");
        int rank = 1;
        for (Student s : allStudents) {
            System.out.println("Rank " + rank++ + ": " + s);
        }
    }
}