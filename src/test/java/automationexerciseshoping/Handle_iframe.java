package automationexerciseshoping;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_iframe {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void loadFramePracticePage() {
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @Test(priority = 2)
    public void addTextInMainFrame() throws InterruptedException {
        WebElement textField = driver.findElement(By.xpath("//input[@id='name']"));
        textField.sendKeys("Gopal Pawar");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", textField);
    }

    @Test(priority = 3)
    public void handleFirstFrame() throws InterruptedException {
        WebElement firstFrame = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(firstFrame);

        Thread.sleep(3000);

        // Select Java from the dropdown
        Reporter.log("Verify that Dropdown selects Java", true);
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='course']"));
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Java");

        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Selected Option: " + selectedOption);

        Thread.sleep(3000);

        // Select Python from the dropdown
        select.selectByVisibleText("Python");
        String selectedOption2 = select.getFirstSelectedOption().getText();
        System.out.println("Selected Option: " + selectedOption2);

        Thread.sleep(3000);

        // Switch back to the main content
        driver.switchTo().defaultContent();
    }

    @Test(priority = 4)
    public void handleSecondFrame() throws InterruptedException {
        WebElement secondFrame = driver.findElement(By.xpath("//iframe[@id='frm2']"));
        driver.switchTo().frame(secondFrame);

        WebElement inputFirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputFirstName.sendKeys("Gopal Pawar");
        Thread.sleep(3000);
        
        WebElement radioBtn1 = driver.findElement(By.xpath("//input[@id='malerb']"));
        radioBtn1.click();
        Thread.sleep(3000);
        Reporter.log("Male Radio button selected", true);

        WebElement radioBtn2 = driver.findElement(By.xpath("//input[@id='femalerb']"));
        radioBtn2.click();
        Thread.sleep(3000);
        Reporter.log("Female Radio button selected", true);
        
        // Switch back to the main content
        driver.switchTo().defaultContent();
    }

    @Test(priority = 5)
    public void goBackToFirstFrame() throws InterruptedException {
        WebElement firstFrame = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(firstFrame);

        // Select Java from the dropdown
        Reporter.log("Verify that Dropdown selects Java", true);
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='course']"));
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Java");

        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Selected Option: " + selectedOption);
        
        Thread.sleep(3000);
        // Switch back to the main content
        driver.switchTo().defaultContent();
    }

    @Test(priority = 6)
    public void takeScreenshot() throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(source, new File("C:\\Users\\LENOVO\\Desktop\\ST\\screenshot.jpg"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
