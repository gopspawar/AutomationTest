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

public class TestRegistrationfunctionality {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
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
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        
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
        username.sendKeys("rajvarma");
        Reporter.log("Entered username: rajvarma", true);
        
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("raj@varma");
        Reporter.log("Entered password", true);
        
        WebElement confirmPass = driver.findElement(By.id("repeatedPassword"));
        confirmPass.sendKeys("raj@varma");
        Reporter.log("Entered password confirmation", true);
        
        Reporter.log("5. Submitting the registration form", true);
        WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")));
        registerBtn.submit();
        
        Reporter.log("6. Verifying successful registration", true);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        String successText = successMessage.getText();
        Assert.assertTrue(successText.contains("Welcome"), "Registration should be successful");
        Reporter.log("Registration successful", true);
    }
    
    @Test(dependsOnMethods = "registerFunctionality")
    public void loginFunctionality() {
        Reporter.log("1. Navigating to the Parabank login page", true);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        Reporter.log("2. Entering username", true);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")));
        usernameField.sendKeys("rajvarma");
        Reporter.log("Entered username: rajvarma", true);
        
        Reporter.log("3. Entering password", true);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        passwordField.sendKeys("raj@varma");
        Reporter.log("Entered password", true);
        
        Reporter.log("4. Clicking on the login button", true);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        loginButton.click();
        
        Reporter.log("5. Verifying successful login", true);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        String successText = successMessage.getText();
        Assert.assertTrue(successText.contains("Accounts Overview"), "Login should be successful");
        Reporter.log("Login successful", true);
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
