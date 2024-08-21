package automationexerciseshoping;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Windows {

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
    public void MainWindow() throws InterruptedException {
        // Open the initial website
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        // Store the main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Click a button or link that opens a new window
        driver.findElement(By.id("newWindowBtn")).click();

        // Wait for the new window to open
        Thread.sleep(3000);

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Loop through all window handles
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(handle);

                // Open a new website in the new window
                driver.get("https://www.automationexercise.com/");
                driver.manage().window().maximize();
                Thread.sleep(3000);
                // Perform other actions on the new window as needed
                // e.g., driver.findElement(By.id("someElement")).click();
            }
        }
                // Close the new window if necessary
                // driver.close();
                
                // Switch back to the main window
                driver.switchTo().window(mainWindowHandle);
            
        }
        
        
            
        

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  }
