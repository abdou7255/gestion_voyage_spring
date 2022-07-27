package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.repository.EmployeeRepository;
import com.esprit.PI.GestionVoyage.repository.FeedBackRepository;
import com.esprit.PI.GestionVoyage.service.FeedBackService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFExporter {
    @Autowired
    private FeedBackRepository feedBackService;


    public PDFExporter(Long id) {

    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Feedback ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Sender Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Receiver Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Content", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
        List<Feedback> listFeedback=new ArrayList<>();
        for(Feedback f : feedBackService.findAll()){
            listFeedback.add(f);
        }
        for (Feedback feedback : listFeedback) {
            table.addCell(String.valueOf(feedback.getIdFeedBack()));
            table.addCell(feedback.getEmployeeSender().getName());
            table.addCell(feedback.getEmployeeReceiver().getName());
            table.addCell(String.valueOf(feedback.getDateFeedBack()));
            table.addCell(feedback.getContent());

        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("List of Employees", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f,1.5f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();

    }
}
