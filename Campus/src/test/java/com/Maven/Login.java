package com.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
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
        
//        WebElement employeeModule = driver.findElement(By.xpath("//p[normalize-space()='Employee']"));
//        employeeModule.click();
//        Thread.sleep(8000);
//
//        WebElement employeeTab = driver.findElement(By.xpath("//div[@class='campusTabbuttonContainer'][.//h3[text()='Employee']]"));
//        employeeTab.click();
//        Thread.sleep(10000);
//        
//        WebElement PlusButton = driver.findElement(By.xpath("//span[normalize-space()='add']"));
//        PlusButton.click();
//        Thread.sleep(2000);
//
//        
//        WebElement Name = driver.findElement(By.xpath("//input[@name=\"name\"]"));
//        Name.sendKeys("Kavita");
//        
//        WebElement Emailid = driver.findElement(By.xpath("//input[@name=\"email\"]"));
//        Emailid.sendKeys("Kavita89@gmail.com");
//        
//        WebElement MobileNumber = driver.findElement(By.xpath("//input[@name=\"mobNumber\"]"));
//        MobileNumber.sendKeys("9861109289");
//        
//        Select gender = new Select(driver.findElement(By.name("Gender")));
//        gender.selectByVisibleText("Female");
//        
//        Select School = new Select(driver.findElement(By.name("Campus")));
//        School.selectByVisibleText("Mafatlal Academy");
//
//        Select Designation = new Select(driver.findElement(By.name("Designation")));
//        Designation.selectByVisibleText("Teacher");
//        
//        WebElement Date = driver.findElement(By.xpath("//input[@name=\"Date\"]"));
//        Date.sendKeys("02-05-2000");
//        
//        WebElement Sumbitbutton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
//        Sumbitbutton.click();
//        
//        
//        

        // Fill in the Add Employee form
        //driver.findElement(By.name("employeeName")).sendKeys("John Doe");        // Example field
        //driver.findElement(By.name("employeeEmail")).sendKeys("johndoe@example.com");
        //driver.findElement(By.name("employeeRole")).sendKeys("Teacher");

        // Submit form
        //WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        //submitButton.click();
        //Thread.sleep(2000);

//        System.out.println("Employee added successfully.");
    }

        

        // Assert the title contains "Google"
       // assert title.contains("Google") : "Test failed! Title doesn't match!";

	@AfterTest
    public void tearDown() {
        driver.quit(); // <-- no condition here
        System.out.println("Browser closed.");
    }




	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

	}

}
