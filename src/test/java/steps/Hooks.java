package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentReportManager;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        driver = DriverFactory.getDriver();
        extent = ExtentReportManager.getInstance();  // Usa tu clase utilitaria
        test = extent.createTest(scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshot);
            test.fail("El escenario falló, captura adjunta")
                .addScreenCaptureFromBase64String(base64Screenshot, "Screenshot fallo");
        } else {
            test.pass("Escenario exitoso");
        }

        extent.flush(); // Guarda el reporte
        DriverFactory.quitDriver();
    }
}

