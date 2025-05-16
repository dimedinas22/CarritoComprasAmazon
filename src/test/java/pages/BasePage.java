package pages;

// Importaciones necesarias
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    protected WebDriverWait wait;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    //static {
      //  WebDriverManager.chromedriver().setup();

        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
       // driver = new ChromeDriver();
    //}
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Método estático para navegar a una URL.
    public static void navegarA(String url) {
        driver.get(url);
    }
     // Método para hacer clic en un enlace basado en el texto visible del enlace
    public void irAlEnlacePorTexto(String textoDelEnlace){
        driver.findElement(By.linkText(textoDelEnlace)).click();
    }
    //Método estático para cerrar la instancia del driver. 
    public static void cerrarNavegador() {
        driver.quit();
    }

    // Método para encontrar un elemento web usando un objeto 'Element' con tipo y localizador
    // Espera explícita a que el elemento esté presente en el DOM antes de devolverlo
    public WebElement Find(Element element) {
    By by;
    switch (element.type.toLowerCase()) {
        case "id": by = By.id(element.locator); break;
        case "name": by = By.name(element.locator); break;
        case "css": by = By.cssSelector(element.locator); break;
        case "xpath": by = By.xpath(element.locator); break;
        default: throw new IllegalArgumentException("Tipo de localizador no válido: " + element.type);
        }
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Método para hacer clic en un elemento encontrado con el método Find
    public void clickElement(Element element) {
        Find(element).click();
    }
    // Método para escribir texto en un campo de entrada (input)
    // Primero limpia el campo y luego envía las teclas
    public void escribe(Element element, String escribirBusqueda){
        Find(element).clear();
        Find(element).sendKeys(escribirBusqueda);
    }
    
    // Método para hacer clic en un elemento específico usando un XPath fijo (por ejemplo, un título)
    public void hacerClickEnElementoEspecifico() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]")));
        element.click();
    }
    // Método que devuelve el texto visible de un elemento WebElement recibido como parámetro
    public String textFromElement(WebElement element) {
    return element.getText();
    }
}
