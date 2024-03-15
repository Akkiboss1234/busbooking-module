package com.busbookingreservation.util;

import com.busbookingreservation.entity.Passenger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
@Service
public class PdfTicketGeneratorService {




        public byte[] generateTicket(Passenger passenger ,String fromLocation ,String toLocation,String fromDate) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try {
                Document document = new Document();
                PdfWriter.getInstance(document, outputStream);
                document.open();

                // Add content to the PDF using passenger data

                document.add(new Paragraph("Ticket information"));
                document.add(new Paragraph("Name: " + passenger.getFirstName() + " " + passenger.getLastName()));
                document.add(new Paragraph("Email: " + passenger.getEmail()));
                document.add(new Paragraph("Mobile: " + passenger.getMobile()));
                document.add(new Paragraph("Bus ID: " + passenger.getBusId()));
                document.add(new Paragraph("Route ID: " + passenger.getRouteId()));
                document.add(new Paragraph("from location: " + fromLocation));
                document.add(new Paragraph("to Location: " +toLocation));
                document.add(new Paragraph("from Date: " + fromDate));
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            return outputStream.toByteArray();
        }
    }



