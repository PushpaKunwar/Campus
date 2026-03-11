package com.Maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubtMenu {
	
	WebDriver driver;
	@BeforeTest

	public void setUp() throws InterruptedException { 
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pushpa Kunwar\\eclipse-workspace\\Campus\\Driver\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    	driver.navigate().to("https://live.mafatlaleducation.com/");
    	driver.manage().window().maximize();
    	
             }
	@Test
	public void openGoogleTest() throws InterruptedException {
        // Open Google website
       // driver.get("https://www.google.com");
		WebElement username = driver.findElement(By.name("name")); // Update 'name' if different
        username.sendKeys("demostudent1@gmail.com");

        // Locate password field
        WebElement password = driver.findElement(By.name("password")); // Update 'name' if different
        password.sendKeys("Student@111");

        // Locate and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
        loginButton.click();

        // Optional: Wait for dashboard or login result
        Thread.sleep(10000);
        
        WebElement CollaboartionModule = driver.findElement(By.xpath("//p[normalize-space()='Collaboration']"));
        CollaboartionModule.click();
        Thread.sleep(8000);
      
        WebElement PlusButton = driver.findElement(By.xpath(" //span[normalize-space()='add']"));
        PlusButton.click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

          // Open dropdown
         WebElement dropdown = wait.until(
         ExpectedConditions.elementToBeClickable(
             By.xpath("//div[@data-name='Subject']//span[contains(text(),'Select')]")
         )
         );
        dropdown.click();

        // Select Science
        WebElement science = wait.until(
         ExpectedConditions.elementToBeClickable(
             By.xpath("//li[normalize-space()='Science']")
         )
     );
     science.click();
     
     WebElement Chapterdropdown = wait.until(
             ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[@role='dialog']//div//div[2]//div[1]//span[1]")
             )
         );
     Chapterdropdown.click();

         // Select chapter
         WebElement Sound = wait.until(
             ExpectedConditions.elementToBeClickable(
                 By.xpath("//li[normalize-space()='Sound']")
             )
         );
         Sound.click();
       
         WebElement Topic = wait.until(
                 ExpectedConditions.elementToBeClickable(
                     By.xpath("//div[@class='filterInputHolder selectInputAddForm_doubt']//span[contains(text(),'Select')]")
                 )
             );
         Topic.click();

             // Select topic
             WebElement ReflectionofSound = wait.until(
                 ExpectedConditions.elementToBeClickable(
                     By.xpath("//li[normalize-space()='Reflection of Sound']")
                 )
             );
             ReflectionofSound.click();
             
             WebElement Title = driver.findElement(By.xpath("//input[@placeholder='Give title to your doubt']"));
             Title.sendKeys("Sounds");
             
             WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Type here']"));
             Description .sendKeys("Why can’t sound travel in vacuum?");
             
            // WebElement UploadAttachments = driver.findElement(By.xpath("//textarea[@placeholder='Type here']"));
             //UploadAttachments.sendKeys("Why can’t sound travel in vacuum?");
             
             WebElement Sumbitbutton = driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']"));
             Sumbitbutton.click();
             Thread.sleep(10000);
	
	}
	
	@AfterTest
    public void tearDown() {
        driver.quit(); 
        System.out.println("Browser closed.");
    }
	
}
