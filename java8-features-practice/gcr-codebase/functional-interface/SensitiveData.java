interface Sensitive {
}


class PatientRecord implements SensitiveData {
    String name;
    String disease;

    PatientRecord(String name, String disease) {
        this.name = name;
        this.disease = disease;
    }
}

class LogRecord {
    String message;

    LogRecord(String message) {
        this.message = message;
    }
}


class DataProcessor {
    static void process(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data...");
        } else {
            System.out.println("Storing normal data...");
        }
    }
}

public class SensitiveData {

    public static void main(String[] args) {

        PatientRecord patient = new PatientRecord("Ravi", "Diabetes");
        LogRecord log = new LogRecord("System started");

        DataProcessor.process(patient);
        DataProcessor.process(log);
    }
}
