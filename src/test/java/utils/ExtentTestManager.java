package utils;

import com.aventstack.extentreports.ExtentTest;

// Clase para manejar el ExtentTest actual, guardado en ThreadLocal para seguridad en ejecución paralela
//Permite que al ejecutar pruebas en paralelo, cada prueba tenga su propio
// contexto de reporte, evitando que los logs se mezclen o se sobrescriban.
public class ExtentTestManager {
    
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void unload() {
        extentTest.remove();
    }
}
