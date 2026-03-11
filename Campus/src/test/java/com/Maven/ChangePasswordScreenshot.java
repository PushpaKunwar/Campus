package com.Maven;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.StandardCopyOption;
	import java.time.Duration;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.ITestResult;
	import org.testng.annotations.*;

	public class ChangePasswordScreenshot {

	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\Pushpa Kunwar\\eclipse-workspace\\Campus\\Driver\\chromedriver.exe");

	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	        driver.manage().window().maximize();
	        driver.get("https://live.mafatlaleducation.com/");
	    }

	    @Test
	    public void openGoogleTest() {

	        // Login
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")))
	                .sendKeys("Kavita77@gmail.com");

	        driver.findElement(By.name("password"))
	                .sendKeys("Best@123");

	        driver.findElement(By.xpath("//button[contains(text(),'Login')]"))
	                .click();

	        // Wait till profile section visible (login success)
	        WebElement profileSection = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[contains(@class,'profileSectionInHeader')]")
	                )
	        );

	        // Click profile dropdown (NOT SVG)
	        profileSection.click();

	        // Click Change Password
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//p[contains(text(),'Change Password')]")
	        )).click();

	        // Change password fields (avoid dynamic IDs if possible)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//input[@type='password'][1]"))
	        ).sendKeys("Rest@123");

	        driver.findElement(By.xpath("(//input[@type='password'])[2]"))
	                .sendKeys("Best@123");

	        driver.findElement(By.xpath("(//input[@type='password'])[3]"))
	                .sendKeys("Best@123");

	        driver.findElement(By.xpath("//button[normalize-space()='Submit']"))
	                .click();
	    }

	    @AfterMethod
	    public void takeScreenshotOnResult(ITestResult result) throws IOException {

	        if (driver != null) {

	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);

	            String status = "";

	            if (result.getStatus() == ITestResult.FAILURE) {
	                status = "FAIL";
	            } else if (result.getStatus() == ITestResult.SUCCESS) {
	                status = "PASS";
	            } else if (result.getStatus() == ITestResult.SKIP) {
	                status = "SKIP";
	            }

	            String fileName = "screenshots/"
	                    + status + "_"
	                    + result.getName() + "_"
	                    + System.currentTimeMillis() + ".png";

	            File dest = new File(fileName);
	            dest.getParentFile().mkdirs();

	            Files.copy(src.toPath(), dest.toPath(),
	                    StandardCopyOption.REPLACE_EXISTING);

	            System.out.println("Screenshot captured: " + fileName);

	            driver.quit();
	        }
	    }
	}



