package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.text.SimpleDateFormat;
import java.util.Date;

// Clase utilitaria para gestionar la creación de reportes con ExtentReports
public class ExtentReportManager {
    // Objeto estático que representa el reporte
    private static ExtentReports extent;

    // Método estático que devuelve una instancia del reporte. Si aún no existe, la crea.
    public static ExtentReports getInstance() {
        if (extent == null) {
            // Se crea una marca de tiempo para generar un nombre único para el archivo del reporte
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Ruta donde se guardará el archivo HTML del reporte
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timeStamp + ".html";
            // Se crea un reporter HTML utilizando ExtentSparkReporter
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
            // Configura el nombre y el título del reporte
            htmlReporter.config().setReportName("Reporte de Pruebas Automatizadas");
            htmlReporter.config().setDocumentTitle("Resultados - Carrito de Compras");
            // Crea una nueva instancia de ExtentReports y adjunta el reporter configurado
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Pryecto", "Automatizacion_Amazon_carrito_compras");
            extent.setSystemInfo("Tester", "Diana_Medina");
        }
        return extent;
    }
}

