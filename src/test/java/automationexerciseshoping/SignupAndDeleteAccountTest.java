package automationexerciseshoping;

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

public class SignupAndDeleteAccountTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testSignupAndDeleteAccount() {
        Reporter.log("1. Launch browser");
        driver.get("http://automationexercise.com");

        Reporter.log("2. Navigate to URL 'http://automationexercise.com'");
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible successfully");

        Reporter.log("3. Verify that home page is visible successfully");

        Reporter.log("4. Click on 'Signup / Login' button");
        WebElement signUpLogin = driver.findElement(By.cssSelector(".fa.fa-lock"));
        signUpLogin.click();

        Reporter.log("5. Verify 'New User Signup!' is visible");
        WebElement newUserSignupText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));
        Assert.assertTrue(newUserSignupText.isDisplayed(), "'New User Signup!' text is not displayed.");

        Reporter.log("6. Enter name and email address");
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.sendKeys("Dipak Pawar");

        WebElement emailField = driver.findElement(By.xpath("(//input[@data-qa='signup-email'])[1]"));
        emailField.sendKeys("dipakpawar@example.com");

        Reporter.log("7. Click 'Signup' button");
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        Reporter.log("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        WebElement enterAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Enter Account Information']")));
        Assert.assertTrue(enterAccountInfo.isDisplayed(), "'Enter Account Information' is not visible.");

        Reporter.log("9. Fill details: Title, Name, Email, Password, Date of birth");
        WebElement titleMr = driver.findElement(By.id("id_gender1"));
        titleMr.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("JohnDoe123");

        WebElement dayOfBirth = driver.findElement(By.id("days"));
        dayOfBirth.sendKeys("1");

        WebElement monthOfBirth = driver.findElement(By.id("months"));
        monthOfBirth.sendKeys("January");

        WebElement yearOfBirth = driver.findElement(By.id("years"));
        yearOfBirth.sendKeys("1990");

        Reporter.log("10. Select checkbox 'Sign up for our newsletter!'");
        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        newsletterCheckbox.click();

        Reporter.log("11. Select checkbox 'Receive special offers from our partners!'");
        WebElement optinCheckbox = driver.findElement(By.id("optin"));
        optinCheckbox.click();

        Reporter.log("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys("Dipak");

        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys("Pawar");

        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys("Example Inc.");

        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys("123 Main Street");

        WebElement address2Field = driver.findElement(By.id("address2"));
        address2Field.sendKeys("Suite 1");

        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.sendKeys("India");

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("Maharashtra");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Pune");

        WebElement zipcodeField = driver.findElement(By.id("zipcode"));
        zipcodeField.sendKeys("400078");

        WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));
        mobileNumberField.sendKeys("1234567890");

        Reporter.log("13. Click 'Create Account' button");
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();

        Reporter.log("14. Verify that 'ACCOUNT CREATED!' is visible");
        WebElement accountCreatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Created!']")));
        Assert.assertTrue(accountCreatedMessage.isDisplayed(), "'Account Created!' is not visible.");

        Reporter.log("15. Click 'Continue' button");
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();

        Reporter.log("16. Verify that 'Logged in as username' is visible");
        WebElement loggedInAs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[contains(text(),'Logged in as')]")));
        Assert.assertTrue(loggedInAs.isDisplayed(), "'Logged in as username' is not visible.");

        Reporter.log("17. Click 'Delete Account' button");
        WebElement deleteAccountButton = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        Reporter.log("18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        WebElement accountDeletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Deleted!']")));
        Assert.assertTrue(accountDeletedMessage.isDisplayed(), "'Account Deleted!' is not visible.");

        WebElement continueAfterDeleteButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueAfterDeleteButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
