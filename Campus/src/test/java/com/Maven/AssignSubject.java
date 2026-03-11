package com.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssignSubject {
	
WebDriver driver;
	
	@BeforeTest
    public void setUp() throws InterruptedException {
        // Set the path for ChromeDriver (ensure you replace the path with your own chromedriver path)
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
        username.sendKeys("demoprincipal@gmail.com");

        // Locate password field
        WebElement password = driver.findElement(By.name("password")); // Update 'name' if different
        password.sendKeys("Account@123");

        // Locate and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
        loginButton.click();

        // Optional: Wait for dashboard or login result
        Thread.sleep(10000);
        
       // WebElement dashboardMenu = driver.findElement(By.xpath("//button[contains(text(), 'Start Class')]"));  // Example
       // dashboardMenu.click();

        // Wait for dashboard to load
        //Thread.sleep(2000);

        System.out.println("Dashboard clicked successfully.");

        System.out.println("Login attempted.");

        // Validate the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        
        WebElement employeeModule = driver.findElement(By.xpath("//p[normalize-space()='Employee']"));
        employeeModule.click();
        Thread.sleep(8000);
        
        WebElement Assignsubjectmenu = driver.findElement(By.xpath("//h3[normalize-space()='Assign Subject']"));
        Assignsubjectmenu.click();
        Thread.sleep(8000);//
        
        WebElement addbtn = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/div[1]/button[1]/span[1]"));
        addbtn.click();
        Thread.sleep(8000);//
        
        
        WebElement addemp  = driver.findElement(By.xpath("//div[@class='addEmployeeButton']"));
        addemp.click();
        Thread.sleep(8000);
        
       WebElement selectemp  = driver.findElement(By.xpath("//span[text()='Select Employee']"));
       selectemp.click();
        Thread.sleep(8000);
        
        WebElement selectteacher  = driver.findElement(By.xpath("//li[normalize-space()='Valen']"));
        selectteacher.click();
         Thread.sleep(8000);
         
         WebElement Clicksave  = driver.findElement(By.xpath("//span[normalize-space()='done']"));
         Clicksave.click();
          Thread.sleep(8000);
         
	}
	
	@AfterTest
    public void tearDown() {
        driver.quit(); // <-- no condition here
        System.out.println("Browser closed.");
	}
	
	
	
	
}

	




