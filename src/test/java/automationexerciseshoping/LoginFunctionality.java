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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Reporter.log("Browser launched and maximized successfully.", true);
    }

    @Test
    public void positiveLoginTest() throws InterruptedException {
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

    @Test
    public void negativeLoginTestInvalidPassword() throws InterruptedException {
        Reporter.log("Starting negative login test with invalid password...", true);

        driver.get("http://automationexercise.com");
        Reporter.log("Navigated to the automation exercise website.", true);

        WebElement signLogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signLogin.click();
        Reporter.log("Clicked on 'Signup / Login' button.", true);

        WebElement username = driver.findElement(By.xpath("(//input[@data-qa='login-email'])[1]"));
        username.sendKeys("rajvarma@gmail.com");
        Reporter.log("Entered valid email address.", true);

        WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        pass.sendKeys("wrongpassword");
        Reporter.log("Entered invalid password.", true);

        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();
        Reporter.log("Clicked on the 'Login' button.", true);

        // Verifying unsuccessful login
        WebElement errorMsg = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid password.");
        Reporter.log("Login failed as expected. Error message is displayed.", true);
    }

    @Test
    public void negativeLoginTestInvalidEmail() throws InterruptedException {
        Reporter.log("Starting negative login test with invalid email...", true);

        driver.get("http://automationexercise.com");
        Reporter.log("Navigated to the automation exercise website.", true);

        WebElement signLogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signLogin.click();
        Reporter.log("Clicked on 'Signup / Login' button.", true);

        WebElement username = driver.findElement(By.xpath("(//input[@data-qa='login-email'])[1]"));
        username.sendKeys("invalidemail@gmail.com");
        Reporter.log("Entered invalid email address.", true);
        System.out.println("Username: "+username);

        WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        pass.sendKeys("rajvarma");
        Reporter.log("Entered valid password.", true);

        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();
        Reporter.log("Clicked on the 'Login' button.", true);

        // Verifying unsuccessful login
        WebElement errorMsg = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid email.");
        Reporter.log("Login failed as expected. Error message is displayed.", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Browser closed successfully.", true);
        }
    }
}
