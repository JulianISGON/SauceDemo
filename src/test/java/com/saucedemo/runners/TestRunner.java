package com.saucedemo.runners;

// Importamos la anotación y clases necesarias para ejecutar pruebas con Cucumber y JUnit
import io.cucumber.junit.Cucumber; // Clase principal para ejecutar pruebas Cucumber con JUnit
import io.cucumber.junit.CucumberOptions; // Permite configurar opciones de ejecución de Cucumber
import org.junit.runner.RunWith; // Permite especificar el runner de JUnit

// Indicamos que esta clase debe ejecutarse con el runner de Cucumber
@RunWith(Cucumber.class)
// Configuramos las opciones de Cucumber para la ejecución de pruebas
@CucumberOptions(
        // Ubicación de los archivos feature (escenarios de prueba en Gherkin)
        features = "src/test/resources/features",
        // Ubicación de los step definitions (implementación de los pasos)
        glue = "com.saucedemo.stepdefinitions",
        // Plugins para reportes y formatos de salida
        plugin = {
                "pretty",    // Muestra la salida formateada en consola
                "html:target/cucumber-reports/cucumber.html",    // Genera reporte HTML en la carpeta target
                "json:target/cucumber-reports/cucumber.json",    // Genera reporte JSON en la carpeta target
                "junit:target/cucumber-reports/cucumber.xml",    // Genera reporte JUnit XML en la carpeta target
                "rerun:target/failed_scenarios.txt"    // Guarda los escenarios fallidos para re-ejecución
        },
        monochrome = true,    // Mejora la legibilidad de la salida en consola
        tags = "@login",      // Ejecuta solo los escenarios que tengan el tag @login
        dryRun = false       // false = ejecuta las pruebas, true = solo verifica que los steps estén implementados
)
// Definimos la clase TestRunner que no requiere métodos ni atributos, solo sirve como punto de entrada para la ejecución
public class TestRunner {
    // Esta clase está vacía porque toda la configuración se realiza mediante anotaciones
}