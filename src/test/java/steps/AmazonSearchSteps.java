package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPage;
import utils.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AmazonSearchSteps {

    WebDriver driver = DriverFactory.getDriver();
    AmazonSearchPage amazon = new AmazonSearchPage(driver);



    @Given("El usuario navega a www.amazon.com")
    public void navegaraAmazon(){
        amazon.navegaraAmazon();
    }
    @And("busca un (.+)$")
    public void ingresarBusqueda(String criteria) {
        amazon.ingresarBusqueda(criteria);
        amazon.clickBuscar();
    }
    @And("Navega a la segunda Pagina")
    public void navegaraSegundaPagina(){
        amazon.irAPagina2();
    }
    @And("Selecciona el tercer item")
    public void seleccionarTercerItem(){
        amazon.seleccionarTercerElemento();
    }
    @Then("agrega al carrito más de dos unidades del tercer ítem si esta disponible para compra")
    public void agregaUnidadesSiDisponibles() {
        amazon.seleccionarCantidadSiDisponible(3);
        amazon.agregaralcarrito();
}
}

