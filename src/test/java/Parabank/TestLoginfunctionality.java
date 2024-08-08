package Parabank;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginfunctionality {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";
    private static final String USERNAME = "rajvarma";
    private static final String PASSWORD = "raj@varma";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Use wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginFunctionality() {
        Reporter.log("1. Navigating to the Parabank login page", true);
        driver.get(BASE_URL);

        Reporter.log("2. Entering username", true);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")));
        usernameField.sendKeys(USERNAME);
        Reporter.log("Entered username: " + USERNAME, true);

        Reporter.log("3. Entering password", true);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        passwordField.sendKeys(PASSWORD);
        Reporter.log("Entered password", true);

        Reporter.log("4. Clicking on the login button", true);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        loginButton.click();

        Reporter.log("5. Verifying successful login", true);
        WebElement loginSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        String loginSuccessText = loginSuccessMessage.getText();
        Reporter.log("Login result: " + loginSuccessText, true);
        Assert.assertTrue(loginSuccessText.contains("Accounts Overview"), "Login should be successful");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
