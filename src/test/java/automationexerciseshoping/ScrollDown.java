package automationexerciseshoping;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown {

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
    public void scrollDown() {
        try {
            driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
            
            // Scrolling down using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);"); // Scroll down

            // Wait for the dropdown element to be visible before interacting
            WebElement selectJava = driver.findElement(By.xpath("//select[@id='course']"));
            wait.until(driver -> selectJava.isDisplayed());

            // Selecting 'Java' from the dropdown
            Select s = new Select(selectJava);
            s.selectByVisibleText("Java");
            Reporter.log("Selected 'Java' from the dropdown", true);

        } catch (Exception e) {
            Reporter.log("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Test(priority = 2)
    public void scrollUp() throws InterruptedException {
        try {
            // Scrolling up using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, -500);"); // Scroll up

            Reporter.log("Scrolled up successfully", true);
        } catch (Exception e) {
            Reporter.log("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    @Test(priority = 2)
    public void scrollIntoView() throws InterruptedException
    {
    	WebElement text = driver.findElement(By.xpath("//input[@id='name']"));
        text.sendKeys("Gopal Pawar");
        Thread.sleep(3000);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to the element
        js.executeScript("arguments[0].scrollIntoView(true);", text);
    	
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
