
Feature: Test Pagina Amazon Carrito de Compras
    
    @Amazon
    Scenario Outline: Como cliente, cuando busco Alexa, quiero ver si la tercera opción en la segunda página está disponible para comprar y se puede agregar al carrito.
        Given El usuario navega a www.amazon.com
        When busca un <producto>
        And Navega a la segunda Pagina
        And Selecciona el tercer item
        Then agrega al carrito dos o mas unidades del tercer item si esta disponible para compra

        Examples:

            |producto |
            |alexa   |
            |xbox |
            
