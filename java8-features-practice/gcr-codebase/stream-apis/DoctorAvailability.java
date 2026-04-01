import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Doctor{
    private String name;
    private String speciality;
    private boolean availableOnWeekend;

    public Doctor(String name, String speciality, boolean availableOnWeekend){
        this.name = name;
        this.speciality = speciality;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getName(){ return name; }
    public String getSpeciality() { return speciality; }
    public boolean getAvailableOnWeekends(){ return availableOnWeekend; }

    @Override
    public String toString(){
        return name + " (" + speciality + ") - " + availableOnWeekend;
    }
}

public class DoctorAvailability {
    public static void main(String[] args){
        List<Doctor> doctors = List.of(
            new Doctor("Dr. A", "Cardiology", true),
            new Doctor("Dr. B", "Neurology", false),
            new Doctor("Dr. C", "Orthopedics", true),
            new Doctor("Dr. D", "Dermatology", true),
            new Doctor("Dr. E", "Pediatrics", false)
        );

        List<Doctor> weekendDocs = doctors.stream()
            .filter(Doctor::getAvailableOnWeekends)
            .sorted(Comparator.comparing(Doctor::getSpeciality))
            .collect(Collectors.toList());

        
        weekendDocs.forEach(System.out::println);

    }
}
