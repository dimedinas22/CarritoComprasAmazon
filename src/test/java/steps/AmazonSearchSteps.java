package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPage;
import utils.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import utils.ExtentTestManager;

public class AmazonSearchSteps {

    WebDriver driver = DriverFactory.getDriver();
    AmazonSearchPage amazon = new AmazonSearchPage(driver);



    @Given("El usuario navega a www.amazon.com")
    public void navegaraAmazon(){
        amazon.navegaraAmazon();
        ExtentTestManager.getTest().log(Status.INFO, "Navega a www.amazon.com");
    }
    @And("busca un (.+)$")
    public void ingresarBusqueda(String criteria) {
        amazon.ingresarBusqueda(criteria);
        amazon.clickBuscar();
        ExtentTestManager.getTest().log(Status.INFO, "Busca el producto: " + criteria);
    }
    @And("Navega a la segunda Pagina")
    public void navegaraSegundaPagina(){
        amazon.irAPagina2();
        ExtentTestManager.getTest().log(Status.INFO, "Navega a la segunda página de resultados");
    }
    @And("Selecciona el tercer item")
    public void seleccionarTercerItem(){
        amazon.seleccionarTercerElemento();
        ExtentTestManager.getTest().log(Status.INFO, "Selecciona el tercer producto");
    }
    @Then("agrega al carrito {int} unidades del tercer item si esta disponible para compra")
    public void agregaUnidadesSiDisponibles(int cantidad) {
        amazon.seleccionarCantidadSiDisponible(cantidad);
        amazon.agregaralcarrito();
        Assert.assertEquals("Agregado al carrito", amazon.mensajeagregadocarrito());
        ExtentTestManager.getTest().log(Status.INFO, "Intenta agregar 2 o más unidades al carrito si está disponible");
}
}

