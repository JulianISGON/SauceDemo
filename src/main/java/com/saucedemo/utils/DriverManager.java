package com.saucedemo.utils;

// Importamos las clases necesarias de Selenium y Java
import org.openqa.selenium.WebDriver; // Controla el navegador
import org.openqa.selenium.chrome.ChromeDriver; // Implementación de WebDriver para Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Permite configurar opciones de Chrome
import java.time.Duration; // Maneja el tiempo de espera

// Definimos la clase DriverManager que administra la instancia de WebDriver
public class DriverManager {
    // Instancia del WebDriver (controla el navegador)
    private WebDriver driver;
    // Tiempo de espera implícita en segundos (constante)
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;

    // Método para obtener la instancia del WebDriver
    public WebDriver getDriver() {
        // Si el driver aún no ha sido inicializado
        if (driver == null) {
            // Configura las opciones del navegador Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");           // Maximiza la ventana al iniciar
            options.addArguments("--disable-notifications");     // Desactiva notificaciones del navegador
            options.addArguments("--disable-popup-blocking");    // Desactiva el bloqueo de popups
            options.addArguments("--remote-allow-origins=*");    // Permite conexiones remotas (útil para Selenium Grid)

            // Inicializa el driver de Chrome con las opciones configuradas
            driver = new ChromeDriver(options);
            // Configura el tiempo de espera implícita para encontrar elementos
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        }
        // Retorna la instancia del WebDriver
        return driver;
    }

    // Método para cerrar y limpiar el WebDriver
    public void quitDriver() {
        // Si el driver está inicializado
        if (driver != null) {
            driver.quit();    // Cierra todas las ventanas y finaliza la sesión del navegador
            driver = null;    // Limpia la referencia para permitir nueva inicialización
        }
    }
}