package Applicationlaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static void main(String[]args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pushpa Kunwar\\eclipse-workspace\\Campus\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		//driver.navigate().to("https://dev.mafatlaleducation.com/");
		By singInLocator=By.partialLinkText("Sign in");
		WebElement signIn=driver.findElement(singInLocator);
		signIn.click();
		System.out.println("Sign in click action got performed");
		driver.close();
	}

}
