package pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Clase que representa la pagina de busqueda de Amazon
public class AmazonSearchPage extends BasePage {

     // Elemento del cuadro de busqueda
    private Element cuadroBusqueda = new Element ("xpath","//input[@id='twotabsearchtextbox']");
     // Boton para ejecutar la busqueda
    private Element botonBusqueda =new Element ("css","#nav-search-submit-button");
     // Elemento que representa el tercer resultado de busqueda
    private Element tercerResultado =new Element ("xpath","(//div[@data-cy='title-recipe']/a)[3]");
    // Selector desplegable para elegir cantidad a comprar
    private Element cantidadcompra= new Element("xpath","//span[@id='a-autoid-0-announce']");
    // Boton para agregar el producto al carrito
    private Element agregarcarrito= new Element ("id","add-to-cart-button");
    // Boton para verificar el mensaje de Agregado al carrito
    private Element validarmensaje = new Element ("xpath","//*[contains(text(),'Agregado al carrito')]");
    
    

    public AmazonSearchPage(WebDriver driver){
        super(driver);

    }
     // Navega a la pagina principal de Amazon
    public void navegaraAmazon(){
        navegarA("https://www.amazon.com/-/es");
        driver.manage().addCookie(new Cookie("lc-main", "en_ES"));
        driver.navigate().refresh();
    }
    //Detiene tiempo de ejecucion para resolver chaptcha manualmente
    public void resolverchaptchat() {
        try {
            Thread.sleep(15000); //pausa de 15 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
      // Escribe el criterio de busqueda en el cuadro
    public void ingresarBusqueda(String criteria){
        escribe(cuadroBusqueda,criteria);
    }
    // Hace clic en el boton de busqueda
    public void clickBuscar(){
        clickElement(botonBusqueda);
    }
    // Navega a la pagina 2 de resultados
    public void irAPagina2(){
        irAlEnlacePorTexto("2");
    }

    //Nevage al tercer elemento que se encuentra en la pagina
    public void seleccionarTercerElemento(){
        clickElement(tercerResultado);
    }
     // Método que retorna la lista de cantidades disponibles en el desplegable
    public List<String> retornarCantidadCompra() {
    try {
        // Hace clic en el selector de cantidad
        clickElement(cantidadcompra);
        // Espera a que el listado de opciones sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//ul[contains(@class,'a-nostyle')]/li/a")));
        // Obtiene todos los elementos <a> que representan las opciones de cantidad
        List<WebElement> opciones = driver.findElements(
            By.xpath("//ul[contains(@class,'a-nostyle')]/li/a"));
        // Lista para almacenar los textos de cada opción
        List<String> valores = new ArrayList<>();
        // Recorre las opciones y añade su texto a la lista
        for (WebElement opcion : opciones) {
            valores.add(opcion.getText().trim());
        }
        // Devuelve la lista de cantidades disponibles
        return valores;
    } catch (Exception e) {
        // Si ocurre algún error (por ejemplo, no se encuentra el dropdown), lanza una excepción
        throw new RuntimeException("No se pudo obtener la lista de cantidades disponibles por falta de stock.", e);
    }
    }
     // Método que selecciona una cantidad específica si está disponible
    public void seleccionarCantidadSiDisponible(int cantidadDeseada) {
        // Obtiene la lista de cantidades disponibles
        List<String> cantidades = retornarCantidadCompra();
        // Verifica si la cantidad deseada está entre las opciones disponibles
        if (cantidades.contains(String.valueOf(cantidadDeseada))) {
            // Si está disponible, localiza y hace clic en esa opción
            WebElement opcion = driver.findElement(
                By.xpath("//a[normalize-space(text())='" + cantidadDeseada + "']"));
            opcion.click();
        } else {
            // Si no está disponible, imprime un mensaje informando al usuario
            System.out.println("No hay " + cantidadDeseada + " unidades disponibles.");
        }
    }
     // Agrega el producto seleccionado al carrito de compras
    public void agregaralcarrito() {
    try {

        // Hacer clic en el botón
        clickElement(agregarcarrito);
        
    } catch (Exception e) {
        System.out.println("No se puede agregar al carrito porque no hay unidades disponibles ");
    }
    }
    //Valida Mensaje de Agregado al carrito
    public String mensajeagregadocarrito(){
        return textFromElement(validarmensaje);
    }
}






