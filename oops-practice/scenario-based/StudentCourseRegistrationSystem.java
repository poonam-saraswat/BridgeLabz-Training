// Base class: Person
class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

// Derived class: Student (Inheritance + Encapsulation)
class Student extends Person {
    private static final int MAX_COURSES = 5;
    private String[] courses;
    private String[] grades;
    private int courseCount;

    public Student(String name, String id) {
        super(name, id);
        this.courses = new String[MAX_COURSES];
        this.grades = new String[MAX_COURSES];
        this.courseCount = 0;
    }

    public void addCourse(String course) throws CourseLimitExceededException {
        if (courseCount >= MAX_COURSES) {
            throw new CourseLimitExceededException("Cannot enroll in more than " + MAX_COURSES + " courses.");
        }
        courses[courseCount] = course;
        grades[courseCount] = "Not Graded"; // default grade
        courseCount++;
    }

    public void dropCourse(String course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                // Shift remaining courses left
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                    grades[j] = grades[j + 1];
                }
                courses[courseCount - 1] = null;
                grades[courseCount - 1] = null;
                courseCount--;
                System.out.println("Dropped course: " + course);
                return;
            }
        }
        System.out.println("Course not found: " + course);
    }

    public void setGrade(String course, String grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                grades[i] = grade;
                return;
            }
        }
        System.out.println("Course not found: " + course);
    }

    public void viewGrades() {
        System.out.println("Grades for " + getName() + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i] + " : " + grades[i]);
        }
    }
}

// Custom Exception
class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}

// Abstract Service (Abstraction)
abstract class RegistrationService {
    public abstract void registerCourse(Student student, String course);
    public abstract void dropCourse(Student student, String course);
    public abstract void assignGrade(Student student, String course, String grade);
    public abstract void showGrades(Student student);
}

// Concrete Implementation
class StudentRegistrationService extends RegistrationService {
    @Override
    public void registerCourse(Student student, String course) {
        try {
            student.addCourse(course);
            System.out.println("Successfully enrolled in: " + course);
        } catch (CourseLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void dropCourse(Student student, String course) {
        student.dropCourse(course);
    }

    @Override
    public void assignGrade(Student student, String course, String grade) {
        student.setGrade(course, grade);
    }

    @Override
    public void showGrades(Student student) {
        student.viewGrades();
    }
}

// Main Class to Test
public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Student student1 = new Student("Poonam", "S101");
        RegistrationService service = new StudentRegistrationService();

        service.registerCourse(student1, "Java Programming");
        service.registerCourse(student1, "Data Structures");
        service.registerCourse(student1, "Database Systems");
        service.registerCourse(student1, "Operating Systems");
        service.registerCourse(student1, "Computer Networks");

        // Trying to exceed limit
        service.registerCourse(student1, "Artificial Intelligence");

        // Assign grades
        service.assignGrade(student1, "Java Programming", "A");
        service.assignGrade(student1, "Data Structures", "B+");

        // Drop a course
        service.dropCourse(student1, "Operating Systems");

        // View grades
        service.showGrades(student1);
    }
}
