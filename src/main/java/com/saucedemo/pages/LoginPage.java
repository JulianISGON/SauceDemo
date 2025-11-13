package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    private static final String BASE_URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(){
        driver.get(BASE_URL);
    }

    public void enterUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
