package automationexerciseshoping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class takeUsernameFromExcel {
	 private WebDriver driver;
	 private WebDriverWait wait;
	
	public void setup() {
	
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	@Test
	public void loginwithexcelData() throws InterruptedException
	{
	
	Reporter.log("Starting positive login test...", true);

    driver.get("http://automationexercise.com");
    Reporter.log("Navigated to the automation exercise website.", true);

    WebElement signLogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
    signLogin.click();
    Reporter.log("Clicked on 'Signup / Login' button.", true);

    WebElement username = driver.findElement(By.xpath("(//input[@data-qa='login-email'])[1]"));
    username.sendKeys("rajvarma@gmail.com");
    Reporter.log("Entered valid email address.", true);

    WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
    pass.sendKeys("rajvarma");
    Reporter.log("Entered valid password.", true);

    WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    loginBtn.click();
    Reporter.log("Clicked on the 'Login' button.", true);

    // Verifying successful login
    WebElement logoutBtn = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
    Assert.assertTrue(logoutBtn.isDisplayed(), "Login failed. Logout button is not visible.");
    Reporter.log("Login successful, 'Logout' button is visible.", true);

    logoutBtn.click();
    Reporter.log("Clicked on 'Logout' button.", true);
}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

