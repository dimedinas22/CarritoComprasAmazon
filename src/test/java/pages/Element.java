package pages;

// Clase que representa un elemento web para ser localizado en una página
public class Element {
    // Tipo de localizador (por ejemplo: "id", "name", "xpath", "cssSelector", etc.)
    public String type;
    // Valor del localizador, es decir, el identificador específico del elemento en el DOM
    public String locator;
    
     // Constructor que inicializa el tipo de localizador y su valor
    public Element(String type, String locator) {
        this.type = type;
        this.locator = locator;
    }
}