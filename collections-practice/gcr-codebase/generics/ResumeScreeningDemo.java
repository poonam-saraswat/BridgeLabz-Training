import java.util.ArrayList;
import java.util.List;

// Abstract base class for all job roles
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    // Each job role defines its own screening criteria
    public abstract String screeningCriteria();
}

// Software Engineer role
class SoftwareEngineer extends JobRole {
    private String primaryLanguage;

    public SoftwareEngineer(String candidateName, String primaryLanguage) {
        super(candidateName);
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public String screeningCriteria() {
        return "Software Engineer | Language: " + primaryLanguage + " | Criteria: Strong coding skills";
    }
}

// Data Scientist role
class DataScientist extends JobRole {
    private String specialization;

    public DataScientist(String candidateName, String specialization) {
        super(candidateName);
        this.specialization = specialization;
    }

    @Override
    public String screeningCriteria() {
        return "Data Scientist | Specialization: " + specialization + " | Criteria: ML/AI expertise";
    }
}

// Product Manager role
class ProductManager extends JobRole {
    private int yearsExperience;

    public ProductManager(String candidateName, int yearsExperience) {
        super(candidateName);
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String screeningCriteria() {
        return "Product Manager | Experience: " + yearsExperience + " years | Criteria: Leadership & Strategy";
    }
}

// Generic Resume class with bounded type parameter
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void processResume() {
        System.out.println("Processing Resume for: " + jobRole.getCandidateName());
        System.out.println(jobRole.screeningCriteria());
    }
}

// Utility class with wildcard method
class ScreeningPipeline {
    public static void processAllResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Screening Candidate: " + role.getCandidateName());
            System.out.println(role.screeningCriteria());
            System.out.println("-----------------------------------");
        }
    }
}

// Demo class
public class ResumeScreeningDemo {
    public static void main(String[] args) {
        // Create resumes for different roles
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", "Java"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", "Deep Learning"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 5));

        // Process individually
        System.out.println("=== Individual Resume Processing ===");
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Store all job roles in a list using wildcard
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(seResume.getJobRole());
        allResumes.add(dsResume.getJobRole());
        allResumes.add(pmResume.getJobRole());

        // Process all resumes dynamically
        System.out.println("\n=== Screening Pipeline ===");
        ScreeningPipeline.processAllResumes(allResumes);
    }
}