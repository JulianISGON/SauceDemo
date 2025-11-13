package com.saucedemo.stepdefinitions;

// Importamos las clases de las páginas y utilidades necesarias para la automatización
import com.saucedemo.pages.LoginPage; // Página de login
import com.saucedemo.utils.DriverManager; // Utilidad para manejar el WebDriver
import io.cucumber.java.After; // Anotación para ejecutar código después de cada escenario
import io.cucumber.java.Before; // Anotación para ejecutar código antes de cada escenario
import io.cucumber.java.en.*; // Anotaciones para los pasos en Gherkin
import org.junit.Assert; // Utilidad para aserciones en pruebas

public class LoginStepDefinitions {
    private LoginPage loginPage;
    private final DriverManager driverManager;

    public LoginStepDefinitions() {
        driverManager = new DriverManager();
    }

    @Before
    public void setUp() {
        // Inicializa el WebDriver y la página antes de cada escenario
        driverManager.getDriver();
        loginPage = new LoginPage(driverManager.getDriver());
    }



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.navigateToLoginPage();
    }

    @Given("I enter username {string}")
    public void i_enter_username(String username) {
        // Llamada al método de la página para introducir el nombre de usuario
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        // Llamada al método de la página para introducir la contraseña
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedMessage) {
        // Obtener el mensaje real de la página y comparar con el esperado
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();
    }
}
