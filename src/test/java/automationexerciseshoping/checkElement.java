package automationexerciseshoping;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkElement {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void Test1() {
        Reporter.log("1. Go to the Web Application");

        Reporter.log("2. Check the visibility of Signup/login option link");
        WebElement signUpLogin = driver.findElement(By.cssSelector(".fa.fa-lock"));
        signUpLogin.click();

        Reporter.log("3. Verify the 'New User Signup' text is displayed");
        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupText.isDisplayed(), "'New User Signup!' text is not displayed.");
        Reporter.log("4. 'New User Signup!' text is displayed correctly");
    }

    @Test
    public void Test2() {
        Reporter.log("Verify that user gets an error message if trying to log in without entering username and password");

        WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupBtn.click();

        try {
            WebElement errorMessage = driver.findElement(By.cssSelector("input:invalid"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed as expected.");
            Reporter.log("Error message displayed correctly: 'Please fill out this field'");
        } catch (NoSuchElementException e) {
            Reporter.log("Error message element not found: " + e.getMessage());
        }

        Reporter.log("Verify the sign-up process with all fields");

        Reporter.log("1. Enter the username in username textfield");
        WebElement username = driver.findElement(By.xpath("//input[@name='name']"));
        username.sendKeys("rajvarma");

        Reporter.log("2. Enter the Email in Email textfield");
        WebElement email = driver.findElement(By.xpath("(//input[@data-qa='signup-email'])[1]"));
        email.sendKeys("rajvarma@gmail.com");

        Reporter.log("3. Click on the SignUp button");
        WebElement signup = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signup.click();

        
        Reporter.log("5. Enter the password in the password field");
        try {
            WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
            pass.sendKeys("RajVarma");
            Reporter.log("Password successfully entered", true);
        } catch (NoSuchElementException e) {
            Reporter.log("Password element not found: " + e.getMessage());
        }
    }

    @Test
    public void Test3() {
        // Additional test logic can be added here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
