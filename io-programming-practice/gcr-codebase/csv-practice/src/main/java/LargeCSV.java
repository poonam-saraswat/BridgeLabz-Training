//package io.programming.practice.csv.q11;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class LargeCSV {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data/large.csv"));
        int count = 0;
        String[] row;

        while ((row = reader.readNext()) != null) {
            count++;
            if (count % 100 == 0)
                System.out.println("Processed: " + count);
        }
        reader.close();
    }
}
