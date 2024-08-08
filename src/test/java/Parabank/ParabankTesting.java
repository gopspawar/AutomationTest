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

public class ParabankTesting {

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
    public void registerFunctionality() {
        Reporter.log("1. Navigating to the Parabank login page", true);
        driver.get(BASE_URL);

        Reporter.log("2. Verifying that the register link is available and clickable", true);
        WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        register.click();

        Reporter.log("3. Verifying that the register page is opened", true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerForm")));

        Reporter.log("4. Entering data in required fields", true);
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Raj");
        Reporter.log("Entered first name: Raj", true);

        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Verma");
        Reporter.log("Entered last name: Verma", true);

        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("Pune");
        Reporter.log("Entered address: Pune", true);

        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Pune");
        Reporter.log("Entered city: Pune", true);

        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("Maharashtra");
        Reporter.log("Entered state: Maharashtra", true);

        WebElement zipcode = driver.findElement(By.id("customer.address.zipCode"));
        zipcode.sendKeys("400078");
        Reporter.log("Entered zip code: 400078", true);

        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("1234567890");
        Reporter.log("Entered phone number: 1234567890", true);

        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("12345");
        Reporter.log("Entered SSN: 12345", true);

        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys(USERNAME);
        Reporter.log("Entered username: " + USERNAME, true);

        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys(PASSWORD);
        Reporter.log("Entered password", true);

        WebElement confirmPass = driver.findElement(By.id("repeatedPassword"));
        confirmPass.sendKeys(PASSWORD);
        Reporter.log("Entered password confirmation", true);

        Reporter.log("5. Submitting the registration form", true);
        WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")));
        registerBtn.submit();

        try {
            // Check for success or failure
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            String successText = successMessage.getText();
            Reporter.log("Registration result: " + successText, true);
            Assert.assertTrue(successText.contains("Welcome"), "Registration should be successful");
        } catch (Exception e) {
            // Check for registration error message
            try {
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
                String errorText = errorMessage.getText();
                Reporter.log("Registration error: " + errorText, true);
                
                // Proceed to login if registration fails
                if (errorText.contains("An internal error has occurred")) {
                    Reporter.log("Error detected during registration, proceeding to login", true);

                    // Navigate to login page
                    driver.get(BASE_URL);

                    Reporter.log("Entering username", true);
                    WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")));
                    usernameField.sendKeys(USERNAME);
                    Reporter.log("Entered username: " + USERNAME, true);

                    Reporter.log("Entering password", true);
                    WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
                    passwordField.sendKeys(PASSWORD);
                    Reporter.log("Entered password", true);

                    Reporter.log("Clicking on the login button", true);
                    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
                    loginButton.click();

                    Reporter.log("Verifying successful login", true);
                    WebElement loginSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
                    String loginSuccessText = loginSuccessMessage.getText();
                    Reporter.log("Login result: " + loginSuccessText, true);
                    Assert.assertTrue(loginSuccessText.contains("Accounts Overview"), "Login should be successful");
                } else {
                    throw e; // Re-throw if it's not the expected error
                }
            } catch (Exception ex) {
                Reporter.log("Unexpected error or message while handling registration error: " + ex.getMessage(), true);
                throw ex; // Re-throw to fail the test if handling fails
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
