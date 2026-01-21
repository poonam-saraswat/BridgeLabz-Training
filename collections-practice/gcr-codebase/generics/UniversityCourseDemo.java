import java.util.ArrayList;
import java.util.List;

// Abstract base class for course types
abstract class CourseType {
    private String courseName;
    private int credits;

    public CourseType(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    // Each course type defines its evaluation method
    public abstract String getEvaluationMethod();
}

// Exam-based course
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Written Exam";
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Assignments & Projects";
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Research Paper & Presentation";
    }
}

// Generic Course class with bounded type parameter
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseInfo() {
        System.out.println(courseType.getCourseName() + " | Credits: " 
                           + courseType.getCredits() + " | " 
                           + courseType.getEvaluationMethod());
    }
}

// Utility class with wildcard method
class UniversityUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " | Credits: " 
                               + course.getCredits() + " | " 
                               + course.getEvaluationMethod());
        }
    }
}

// Demo class
public class UniversityCourseDemo {
    public static void main(String[] args) {
        // Create different types of courses
        ExamCourse mathExam = new ExamCourse("Mathematics", 4);
        AssignmentCourse csAssignment = new AssignmentCourse("Computer Science", 3);
        ResearchCourse physicsResearch = new ResearchCourse("Physics Research", 5);

        // Manage them using generic Course class
        Course<ExamCourse> examCourse = new Course<>(mathExam);
        Course<AssignmentCourse> assignmentCourse = new Course<>(csAssignment);
        Course<ResearchCourse> researchCourse = new Course<>(physicsResearch);

        // Display individual course info
        System.out.println("=== Individual Course Info ===");
        examCourse.displayCourseInfo();
        assignmentCourse.displayCourseInfo();
        researchCourse.displayCourseInfo();

        // Store all in a list using wildcard
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(mathExam);
        allCourses.add(csAssignment);
        allCourses.add(physicsResearch);

        // Display all courses dynamically
        System.out.println("\n=== All Courses in University ===");
        UniversityUtils.displayAllCourses(allCourses);
    }
}