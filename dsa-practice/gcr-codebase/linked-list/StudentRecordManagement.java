// Node class representing each student record
class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List class for managing student records
class StudentLinkedList {
    private StudentNode head;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int rollNo, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by Roll Number
    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Record deleted successfully!");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Record not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Record deleted successfully!");
        }
    }

    // Search by Roll Number
    public void searchByRollNo(int rollNo) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Record Found: RollNo=" + temp.rollNo +
                        ", Name=" + temp.name + ", Age=" + temp.age + ", Grade=" + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found!");
    }

    // Update Grade by Roll Number
    public void updateGrade(int rollNo, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found!");
    }

    // Display all records
    public void displayRecords() {
        if (head == null) {
            System.out.println("No records to display!");
            return;
        }
        StudentNode temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("RollNo=" + temp.rollNo + ", Name=" + temp.name +
                    ", Age=" + temp.age + ", Grade=" + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class to test the program
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        // Adding records
        list.addAtBeginning(101, "Alice", 20, "A");
        list.addAtEnd(102, "Bob", 21, "B");
        list.addAtPosition(2, 103, "Charlie", 22, "C");

        // Display records
        list.displayRecords();

        // Search record
        list.searchByRollNo(102);

        // Update grade
        list.updateGrade(103, "A+");

        // Delete record
        list.deleteByRollNo(101);

        // Display after deletion
        list.displayRecords();
    }
}
