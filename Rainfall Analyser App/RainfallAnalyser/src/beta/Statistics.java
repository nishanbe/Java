package beta;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {


    String filePath;
    ArrayList<String> codeRecords = new ArrayList<>();
    ArrayList<Integer> dayRecords = new ArrayList<>();
    ArrayList<Integer> monthRecords = new ArrayList<>();
    ArrayList<Integer> yearRecords = new ArrayList<>();
    ArrayList<Double> rainfallRecords = new ArrayList<>();

    // Format values with consistent decimals
    DecimalFormat df2 = new DecimalFormat("0.00");


    public Statistics(String filePath) {
        this.filePath = filePath;
        this.codeRecords = codeRecords;
        this.dayRecords = dayRecords;
        this.monthRecords = monthRecords;
        this.yearRecords = yearRecords;
        this.rainfallRecords = rainfallRecords;

    }

    public void countRecord() throws FileNotFoundException {

        try {
            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withSkipHeaderRecord().withHeader("Code", "Station", "Year",
                    "Month", "Day", "Rainfall", "Period", "Quality").parse(in);
            String code;
            int day;
            int month;
            int year;
            double rainFall;

            // Create an ArrayList to collect daily rainfalls for a period of each month


            for (CSVRecord record : records) {

                // Convert days months and years from stings to ints
                code = record.get("Code");
                day = Integer.parseInt(record.get("Day"));
                month = Integer.parseInt(record.get("Month"));
                year = Integer.parseInt(record.get("Year"));
                rainFall = convertEmptyValueToZero(record);


                codeRecords.add(code);
                dayRecords.add(day);
                monthRecords.add(month);
                yearRecords.add(year);
                rainfallRecords.add(rainFall);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath() {
        return filePath;
    }

    // Handle empty values before converting to rain fall to doubles
    private static double convertEmptyValueToZero(CSVRecord record) {
        double rainFall;
        if (record.get("Rainfall").isEmpty()) {
            rainFall = 0.0;
        } else {
            rainFall = Double.parseDouble(record.get("Rainfall"));
        }
        return rainFall;
    }


    public String getFileName() {
        String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
        return fileName;
    }
    
    public int getRecordCount() {
        return codeRecords.size();
    }

    public int getStartYear() {
        return Collections.min(yearRecords);
    }

    public int getEndYear() {
        return Collections.max(yearRecords);
    }

    public double getMaxRain() {
        return Collections.max(rainfallRecords);
    }

    public double getRainfallSum() {
        double sum = 0;
        for (int i = 0; i < rainfallRecords.size(); i++) {
            sum += rainfallRecords.get(i);
        }
        return Double.parseDouble(df2.format(sum));
    }
    
    public String getSummary(){
        String stats;
        stats =
        "Number of Records:\t" + getRecordCount() + "\n"+
        "Starting Year:\t\t"+getStartYear() + "\n"+
        "Ending Year:\t\t"+getEndYear() + "\n"+
        "Max Rain in a Day:\t"+getMaxRain() + "\n"+
        "Total Rainfall:\t\t"+getRainfallSum() + "\n"+
        "Processed From:\t\t"+getFileName() + "\n";
        return stats;
    }

    public String getSummaryInline(){
        String stats;
        stats =
                "Records: " + getRecordCount() + "   "+
                "Starting Year: "+getStartYear() + "   "+
                "Ending Year: "+getEndYear() + "   "+
                "Max Rain in a Day: "+getMaxRain() + "   "+
                "Total Rainfall: "+getRainfallSum() + "   "+
                "Processed From: "+getFileName();
        return stats;
    }

}
