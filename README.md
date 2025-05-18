


## Desafío 1: Replica Escenario De Prueba Con Selenium Y Cucumber

### 🧪 Descripción del Proyecto

Este proyecto consiste en replicar un escenario de prueba automatizado sobre el sitio web de Amazon.com, utilizando Selenium WebDriver, Cucumber y Gradle. El flujo automatiza una búsqueda de “Productos", navega a la segunda página de resultados y, si el tercer producto está disponible, agrega dos o más unidades al carrito de compras.

Criterios de aceptacion
Escenario - Cargar al carrito de compra un producto encontrado a través de búsqueda con nombre del artículo
Dado - el usuario navega en www.amazon.com
Cuando - busca el artículo "Alexa"
Y - navega a la página 2 de los resultados de búsqueda obtenidos
Y - selecciona el tercer ítem de los resultados 
Entonces - agrega al carrito más de dos unidades del tercer ítem si esta disponible para compra.

### ¿Qué es Selenium WebDriver?

Selenium WebDriver es una colección de APIs utilizadas para automatizar la interacción con navegadores web. Permite simular las acciones de un usuario real para validar funcionalidades en aplicaciones web.

### ¿Qué es Cucumber?

Cucumber es una herramienta BDD que permite escribir pruebas en lenguaje natural usando el formato Gherkin. Se usa para facilitar la colaboración entre desarrolladores y testers.

### ¿Qué es Gradle?
Gradle es una herramienta de automatización que facilita la gestión de dependencias, construcción y ejecución del proyecto.









## 🧰 Herramientas y Versiones Usadas

### ☕ Java Development Kit (JDK) : Version 21 

Este proyecto está desarrollado utilizando Java Development Kit (JDK) versión 21, por lo que es necesario tener esta versión instalada para compilar y ejecutar el código correctamente.

### 🔧 ¿Qué es el JDK?
El JDK (Java Development Kit) es un conjunto de herramientas proporcionado por Oracle (u otros distribuidores) que permite desarrollar, compilar y ejecutar aplicaciones Java. Incluye el JRE (Java Runtime Environment), el compilador javac, y herramientas como javadoc, jar, etc.

 🛠️ Instalación del JDK 21

Opción 1: Descargar desde el sitio oficial de Oracle
Visita: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
Descarga el instalador correspondiente a tu sistema operativo (Windows, macOS, Linux).
Sigue los pasos de instalación.

✅ Verificar instalación
Después de instalar, abre una terminal y ejecuta: java -version

## 📦 Manejador de Dependencias

Este proyecto utiliza Gradle Version 8.12 para la gestión de dependencias y la automatización de tareas.


🔧 Instalación de Gradle
Ve al sitio oficial de descargas de Gradle: https://gradle.org/releases/
Descarga la versión binaria más reciente (o compatible con tu proyecto).
Descomprime el archivo ZIP en una ubicación de tu preferencia.
Agrega la ruta del directorio bin de Gradle a la variable de entorno PATH.

✅ Verificar instalación
Después de la instalación, abre una terminal o CMD y ejecuta: gradle --version

### Extensiones de VS code
Para este proyecto se utilizaron alguna extensiones de VS Code que ayudan a . Las extensiones que vamos a descargar son:

Extension Pack for Java
Gradle for Java
Gradle Language Support
Cucumber
Snippets and Syntax Highlight for Gherkin (Cucumber)

###  Dependencias

Para este proyecto desarrollado en Java con Gradle, se agregaron varias dependencias en el archivo build.gradle, las cuales fueron obtenidas desde el repositorio https://mvnrepository.com/repos/central
 
Selenium Java: Version 4.32.0   
Cucumber JVM (Java): Version 7.22.0
Cucumber JVM (JUnit 4): Version	7.22.0          
TestNG: Version	7.10.2  
WebDriverManager (Bonigarcia): Version 6.0.1

### 🌐 Navegador Utilizado para las Pruebas Automatizadas
Este proyecto utiliza Google Chrome como navegador principal para la ejecución de pruebas automatizadas con Selenium WebDriver.

✅ Requisitos para usar Google Chrome
Tener Google Chrome instalado en el sistema (se recomienda la última versión estable).
Asegurarse de que la versión del navegador sea compatible con el ChromeDriver utilizado por WebDriverManager.


### ⚙️ Instalación

1.Clona el repositorio:
git clone https://github.com/dimedinas22/CarritoComprasAmazon.git
cd CarritoComprasAmazon
2.Asegúrate de tener el WebDriver correspondiente a tu navegador en el sistema y que su ruta esté configurada en las variables de entorno.



### 🚀 Ejecución de Pruebas

Para ejecutar las pruebas automatizadas, utiliza el siguiente comando en la terminal: gradle test

### 📁 Estructura del Proyecto

CarritoComprasAmazon/
├── .gradle/                        # Archivos internos generados por Gradle
├── .vscode/                        # Configuraciones del entorno en Visual Studio Code
├── bin/                            # Archivos compilados (opcional)
├── build/                          # Carpeta de salida generada por Gradle
├── gradle/                         # Archivos internos de configuración de Gradle
├── reports/                        # Reportes generados por la ejecución de pruebas
├── src/
│   └── test/
│       ├── java/
│       │   └── [paquete base]/
│       │       ├── pages/          # Clases del patrón Page Object
│       │       ├── runner/         # Runner de Cucumber (con JUnit)
│       │       ├── steps/          # Definición de pasos de Cucumber
│       │       └── utils/          # Utilidades auxiliares 
│       └── resources/
│           ├── features/           # Escenarios definidos en Gherkin (.feature)
│           │   └── AmazonSearch.feature
│           └── cucumber.properties # Configuraciones específicas de Cucumber
├── target/                         # Carpeta generada durante la compilación
├── .gitattributes                  # Reglas para el tratamiento de archivos en Git
├── .gitignore                      # Archivos y carpetas que se excluyen del control de versiones
├── build.gradle                    # Script principal de construcción del proyecto con Gradle
├── gradlew                         # Script para usar el wrapper de Gradle (Linux/macOS)
├── gradlew.bat                     # Script para usar el wrapper de Gradle (Windows)
└── settings.gradle                 # Configuración de módulos del proyecto
