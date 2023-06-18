package org.example.services.impl;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;

import java.sql.Connection;
import java.util.HashMap;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ReportService {
    private AppDbContext context = new AppDbContext();
    private Connection connection = context.getConnection();
    public void print(String src) {
        try {
            String filePath = "src/main/java/org/example/reports/" + src;
            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, null, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    public void print(String src, HashMap parameters) {
        try {
            String filePath = "src/main/java/org/example/reports/" + src;
            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, parameters, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
