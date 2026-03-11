package com.Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1{

	WebDriver driver;
	
	@BeforeTest
    public void setUp() {
        // Set the path for ChromeDriver (ensure you replace the path with your own chromedriver path)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pushpa Kunwar\\eclipse-workspace\\Campus\\Driver\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    	driver.navigate().to("https://chatgpt.com/");
    }
	
	@Test
    public void openGoogleTest() {
        // Open Google website
       // driver.get("https://www.google.com");

        // Validate the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        // Assert the title contains "Google"
       // assert title.contains("Google") : "Test failed! Title doesn't match!";
    }

	@AfterTest
    public void tearDown() {
        driver.quit(); // <-- no condition here
        System.out.println("Browser closed.");
    }

	}

