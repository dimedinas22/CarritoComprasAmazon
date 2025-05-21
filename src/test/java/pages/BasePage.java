package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 


public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    protected WebDriverWait wait;
    /*
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
    // Método que hace clic en un elemento desplegable y retorna una lista con los textos de las opciones visibles
    public List<String> obtenerOpcionesDeDropdown(Element elementodesplegable, String opcionesXPath) {
    try {
        // Hace clic en el elemento que despliega las opciones
        clickElement(elementodesplegable);
        // Espera a que las opciones del desplegable sean visibles en el DOM
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(opcionesXPath)));
        // Obtiene todos los elementos <a> u otros que correspondan a las opciones del desplegable
        List<WebElement> opciones = driver.findElements(By.xpath(opcionesXPath));
        // Lista donde se almacenarán los textos de las opciones disponibles
        List<String> valores = new ArrayList<>();
        // Recorre cada opción y añade su texto (sin espacios extra) a la lista
        for (WebElement opcion : opciones) {
            valores.add(opcion.getText().trim());
        }
        // Retorna la lista con los textos de las opciones disponibles
        return valores;
    } catch (Exception e) {
        throw new RuntimeException("No se pudo obtener la lista de cantidades disponibles por falta de stock.", e);
    }
}
// Método que selecciona una opción dentro de un dropdown haciendo clic en el texto exacto
public void seleccionarOpcionEnDropdown(String textoOpcion) {
    try {
        // Busca la opción en el DOM usando su texto
        WebElement opcion = driver.findElement(
            By.xpath("//a[normalize-space(text())='" + textoOpcion + "']"));
            // Hace clic en la opción encontrada
        opcion.click();
    } catch (NoSuchElementException e) {
        // Si la opción no existe, imprime un mensaje informativo
        System.out.println("La opción '" + textoOpcion + "' no está disponible en el dropdown.");
    }
}
    // Método que devuelve el texto visible de un elemento WebElement recibido como parámetro
    public String textFromElement(Element element) {
    return Find(element).getText();
    }

}
