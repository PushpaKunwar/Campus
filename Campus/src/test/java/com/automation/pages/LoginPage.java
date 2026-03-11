package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By username = By.name("name");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
