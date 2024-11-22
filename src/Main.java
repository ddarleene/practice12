import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        try (FileInputStream excelFile = new FileInputStream(new File("src/students.xlsx"));
             Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                double currentScholarship = row.getCell(1).getNumericCellValue();
                double newScholarship = row.getCell(2).getNumericCellValue();
                students.add(new Student(name, currentScholarship, newScholarship));
            }
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
        for (Student student : students) {
            System.out.printf("student: %s, scholarship increase: %.2f%n",
                    student.getName(), student.getScholarshipIncrease());
        }
    }
}
