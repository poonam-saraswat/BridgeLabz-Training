package annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Class with method having multiple bug reports
class SoftwareModule {

    @BugReport(description = "NullPointerException occurs when input is null")
    @BugReport(description = "Performance issue with large datasets")
    public void processData() {
        System.out.println("Processing data...");
    }
}

// Driver class with a different name
public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        // Get method reference
        var method = SoftwareModule.class.getMethod("processData");

        // Retrieve all BugReport annotations
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        // Print all bug reports
        for (BugReport report : bugReports) {
            System.out.println("Bug Report: " + report.description());
        }
    }
}