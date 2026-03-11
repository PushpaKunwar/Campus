package com.Maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddDesignation {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Pushpa Kunwar\\eclipse-workspace\\Campus\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://live.mafatlaleducation.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void loginAndOpenAddDesignation() {

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        username.sendKeys("demoprincipal@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Account@123");

        WebElement loginButton = driver.findElement(
                By.xpath("//button[contains(text(),'Login')]"));
        loginButton.click();

        System.out.println("Login attempted");

        WebElement employeeModule = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[normalize-space()='Employee']")));
        employeeModule.click();

        WebElement addDesignation = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='add']")));
        addDesignation.click();
    }

    @Test(priority = 2)
    public void addField() throws InterruptedException {

        WebElement designation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Enter your designation']")));
        designation.sendKeys("HOD 1");

        Thread.sleep(1500);

        WebElement priority = driver.findElement(
                By.xpath("//input[@placeholder='Enter priority']"));
        priority.sendKeys("12");

        Thread.sleep(1500);
  
        // Wait for module table
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'styled')]")));

        // Locate checkbox
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='menuNameInputContainer']//label)[1]")));

        // Scroll and click
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox).click().perform();

        // Click Submit
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-submit')]")));
        actions.moveToElement(submitBtn).click().perform();

        Thread.sleep(1000);


        System.out.println("Designation added successfully");
    }
    @AfterTest
    public void tearDown() {
        driver.quit(); // <-- no condition here
        System.out.println("Browser closed.");
    }
}