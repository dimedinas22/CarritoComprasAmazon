package pages;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v134.webauthn.WebAuthn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //Inicializa WebDriver para Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navegamosAamazon(){
        //Navega a la pagina web
        driver.get("https://www.amazon.com");
    }

    @AfterMethod
    public void tearDown(){
        //Cierra el navegador despues de la prueba
        if (driver != null){
        driver.quit();
        }
    }   
}
