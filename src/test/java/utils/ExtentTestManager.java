package utils;

import com.aventstack.extentreports.ExtentTest;

// Clase para manejar el ExtentTest actual, guardado en ThreadLocal para seguridad en ejecución paralela
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
