package automationexerciseshoping;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class makeMytrip {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void searchFlight() throws InterruptedException {
        Reporter.log("Verify login functionality with Google account", true);

        // Open MakeMyTrip website
        driver.get("https://www.makemytrip.com/");
        
        Thread.sleep(3000); // explicit wait

        // Close the modal if it appears
        Reporter.log("Close the button successfully", true);
        WebElement closebtn = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closebtn.click();

        Thread.sleep(3000); // explicit wait

        // Select the 'From' city
        Reporter.log("Select the From city successfully", true);
        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/label/p/span"));
        fromCity.click(); // click on the field to activate it
        
        WebElement fromInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
         
        Select s = new Select(fromInput);
        
        s.selectByVisibleText("Mumbai, India");
        
        
        Thread.sleep(3000); // explicit wait
//
//        // Select the 'To' city
//        Reporter.log("Select the To city successfully", true);
//        WebElement toCity = driver.findElement(By.xpath("//input[@id='toCity']"));
//        toCity.click(); // click on the field to activate it
//        
//        WebElement toInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
//        toInput.sendKeys("Pune, India");
//        Thread.sleep(2000); // wait for suggestions to load
//        toInput.sendKeys(org.openqa.selenium.Keys.ENTER); // select the first option
//        
//        Thread.sleep(3000); // explicit wait
//
//        // Select the departure date
//        Reporter.log("Select the departure date successfully", true);
//        WebElement departureDate = driver.findElement(By.xpath("//input[@id='departure']"));
//        departureDate.click();
//        
//        Thread.sleep(3000); // explicit wait
        
        // Select a specific date from the date picker (e.g., 15th of the current month)
        WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label='Fri Aug 15 2024']"));
        selectDate.click();

        Thread.sleep(3000); // explicit wait
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
