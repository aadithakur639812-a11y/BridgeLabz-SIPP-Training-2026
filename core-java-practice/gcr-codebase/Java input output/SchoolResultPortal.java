import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "student_results.txt";
        String outputFile = "report_card.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile, true)) {
            String line;

            writer.write("Student Report Card\n");
            writer.write("-------------------\n");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0].trim();
                int total = 0;
                int subjectCount = parts.length - 1;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i].trim());
                }

                double average = (double) total / subjectCount;
                writer.write("Name: " + name + ", Total: " + total + ", Average: " + average + "\n");
            }

            writer.write("\n");
            System.out.println("Report card written successfully");
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException exception) {
            System.out.println("Error while reading or writing file");
        }
    }
}
