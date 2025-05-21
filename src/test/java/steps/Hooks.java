package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentReportManager;
import utils.ExtentTestManager;

public class Hooks {
    
    
    private WebDriver driver;

    // Método que se ejecuta antes de cada escenario
    @Before
    public void setup(Scenario scenario) {
        driver = DriverFactory.getDriver();
        ExtentReports extent = ExtentReportManager.getInstance();
        ExtentTest test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);
    }

    // Método que se ejecuta después de cada escenario
    @After
    public void teardown(Scenario scenario) {
        ExtentTest test = ExtentTestManager.getTest();
        // Captura de pantalla
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshot);

        if (scenario.isFailed()) {
            test.fail("El escenario falló, captura adjunta")
                .addScreenCaptureFromBase64String(base64Screenshot, "Screenshot fallo");
        } else {
            test.pass("Escenario exitoso, captura adjunta")
                .addScreenCaptureFromBase64String(base64Screenshot, "Screenshot Éxito");
        }
        // Se finaliza y escribe el reporte
        ExtentReportManager.getInstance().flush();
        ExtentTestManager.unload();
        DriverFactory.quitDriver();
    }
}

