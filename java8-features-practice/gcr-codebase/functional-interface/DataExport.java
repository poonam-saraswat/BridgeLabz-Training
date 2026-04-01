interface ExportReport{
    void export(String data);
    default void exportJson(String data){
        System.out.println("Exporting data to a JSON file.");
    }
}

class CSVExport implements ExportReport{
    @Override
    public void export(String data){
        System.out.println("Exporting data into CSV.");
    }
}

class PDFExport implements ExportReport{
    @Override
    public void export(String data){
        System.out.println("Exporting data into PDF.");
    }
}

public class DataExport {
    public static void main(String[] args){
        ExportReport csv = new CSVExport();
        ExportReport pdf = new PDFExport();

        String report = "Sales Report 2026";

        csv.export(report);
        csv.exportJson(report); 

        pdf.export(report);
        pdf.exportJson(report);
    }
}
