import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

class Student{
    private String name;
    private String gradeLevel;

    public Student(String name, String gradeLevel){
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public String getName(){ return name; }
    public String getGradeLevel(){ return gradeLevel; }
}

public class StudentResultGrouping{
    public static void main(String[] args){
        List<Student> students = List.of(
            new Student("Amit", "Grade 10"),
            new Student("Neha", "Grade 9"),
            new Student("Rahul", "Grade 10"),
            new Student("Priya", "Grade 9"),
            new Student("Karan", "Grade 11")
        );

        Map<String, List<String>> gradeGrouped = students.stream()
            .collect(
                Collectors.groupingBy(Student::getGradeLevel, Collectors.mapping(Student::getName, Collectors.toList())) 
        );

        gradeGrouped.forEach((grade, names) -> 
            System.out.println(grade + " : " + names)
        );
    }
}