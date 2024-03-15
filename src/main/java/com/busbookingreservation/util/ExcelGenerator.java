package com.busbookingreservation.util;



import com.busbookingreservation.entity.Passenger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@Service
public class ExcelGenerator {





        public byte[] generateExcelFile(List<Passenger> passengers) throws IOException {
            // Create a new workbook
            try (Workbook workbook = new XSSFWorkbook()) {
                // Create a sheet
                Sheet sheet = workbook.createSheet("Passenger Data");

                // Create header row
                Row headerRow = sheet.createRow(0);
                String[] headers = {"ID", "First Name", "Last Name", "Email", "Mobile", "Bus ID", "Route ID"};
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }

                // Create data rows
                int rowNum = 1;
                for (Passenger passenger : passengers) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(passenger.getId());
                    row.createCell(1).setCellValue(passenger.getFirstName());
                    row.createCell(2).setCellValue(passenger.getLastName());
                    row.createCell(3).setCellValue(passenger.getEmail());
                    row.createCell(4).setCellValue(passenger.getMobile());
                    row.createCell(5).setCellValue(passenger.getBusId());
                    row.createCell(6).setCellValue(passenger.getRouteId());
                }

                // Write the workbook to a file
                ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
                workbook.write(outputStream) ;
                 return outputStream.toByteArray();
            }
        }
    }


