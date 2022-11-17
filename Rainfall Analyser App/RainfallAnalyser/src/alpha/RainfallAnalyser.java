package alpha;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class RainfallAnalyser {
    public static void main(String[] args) {

        String fileName = "resources/Sydney.csv";
        String analysedFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "_analysed.csv";

        try {
            Reader in = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withSkipHeaderRecord().withHeader("Code", "Station", "Year",
                    "Month", "Day", "Rainfall", "Period", "Quality").parse(in);
            int year;
            int month;
            int currentYear = 0;
            int currentMonth = 1;
            double rainFall;
            double totalOfMonth = 0.0;
            double minOfMonth = 0;
            double maxOfMonth = 0;
            StringBuilder recordsCollector = new StringBuilder();

            // Create an ArrayList to collect daily rainfalls for a period of each month
            ArrayList<Double> dailyRainfallsOfMonth = new ArrayList<>();

            for (CSVRecord record : records) {

                // Convert days months and years from stings to ints
                month = Integer.parseInt(record.get("Month"));
                year = Integer.parseInt(record.get("Year"));

                // Initialising the year
                if (currentYear == 0) {
                    currentYear = year;
                }

                rainFall = convertEmptyValueToZero(record);

                // Calculate the total rainfalls of each month and add them to ArrayList
                if (currentMonth == month) {
                    // Collect the rain fall of a day and add it to the total
                    dailyRainfallsOfMonth.add(rainFall);
                    totalOfMonth += rainFall;
                } else {

                    // Find the maximum rain falls of a particular month
                    maxOfMonth = Collections.max(dailyRainfallsOfMonth);

                    // Disregard 0 values (to avoid non-rainy days with finding the minimum rainfalls
                    removeZeroValues(totalOfMonth, dailyRainfallsOfMonth);

                    // Find the minimum rain falls of a particular month
                    minOfMonth = Collections.min(dailyRainfallsOfMonth);

                    //Collect record and append it to a string
                    recordsCollector.append(recordCollector(currentYear, currentMonth, totalOfMonth, minOfMonth, maxOfMonth));

                    // Reset gathered/calculated values and switch to the next month
                    totalOfMonth = rainFall;
                    currentYear = year;
                    currentMonth = month;
                    dailyRainfallsOfMonth.clear();

                    // Add a rain fall of a day
                    dailyRainfallsOfMonth.add(rainFall);
                }
            }

            //Write all collected records to _analysed file
            recordsCollector.append(recordCollector(currentYear, currentMonth, totalOfMonth, minOfMonth, maxOfMonth));
            writeToFile(new File(analysedFileName), recordsCollector.toString());

        } catch (Exception e) {
            System.out.print("File Error: Unable to read the file.");
        }
    }

    // Format values with consistent decimals
    private static final DecimalFormat df2 = new DecimalFormat("0.00");

    // Disregard 0 values (to avoid non-rainy days with finding the minimum rainfalls
    private static void removeZeroValues(double totalOfMonth, ArrayList<Double> dailyRainfallsOfMonth) {
        if (totalOfMonth > 0) {
            dailyRainfallsOfMonth.removeIf(n -> (n == 0));
        }
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

    // Collect a record and store it into a variable
    private static String recordCollector(int currentYear, int currentMonth, double totalOfMonth, double minOfMonth,
                                          double maxOfMonth) {

        return currentYear + "," + currentMonth + "," + df2.format(totalOfMonth) + "," + df2.format(minOfMonth) + "," +
                df2.format(maxOfMonth) + "\n";
    }

    // Write analysed data to a file
    private static void writeToFile(File analysedFileName, String recordsCollector) throws IOException {
        FileWriter writer = new FileWriter(analysedFileName, false);
        System.out.print(recordsCollector);
        writer.write(recordsCollector);
        writer.close();
    }
}