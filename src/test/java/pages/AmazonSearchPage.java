package pages;

import java.util.List;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;




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
     // Selecciona la cantidad de producto a agregar al carrito
    public void seleccionarCantidadSiDisponible(int cantidadDeseada) {
    // Obtiene la lista de cantidades disponibles desde el menú desplegable
    List<String> cantidades = obtenerOpcionesDeDropdown(
        cantidadcompra, "//ul[contains(@class,'a-nostyle')]/li/a");
    // Verifica si la cantidad deseada se encuentra en la lista de opciones
    if (cantidades.contains(String.valueOf(cantidadDeseada))) {
    // Si está disponible, selecciona la opción correspondiente haciendo clic en ella
        seleccionarOpcionEnDropdown(String.valueOf(cantidadDeseada));
    } else {
    // Si no está disponible, informa al usuario por consola
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






