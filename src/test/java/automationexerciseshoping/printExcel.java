package automationexerciseshoping;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printExcel {

    WebDriver driver;
    WebDriverWait wait;
    ExcelUtils excelUtils;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        // Initialize ExcelUtils with the path to your Excel file
        excelUtils = new ExcelUtils("C:\\Users\\LENOVO\\Desktop\\Projects-20240229T130642Z-001\\Projects\\BCA application\\Test Cases\\Master\\UserRoles.xlsx");
    }

    @Test(priority = 1)
    public void loadFramePracticePage() {
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @Test(priority = 2)
    public void addTextInMainFrame() throws InterruptedException {
        // Get data from Excel sheet
        String textValue = excelUtils.getCellData("UserRole", 1, 1);

        // Enter the value into the text box
        WebElement textField = driver.findElement(By.xpath("//input[@id='name']"));
        textField.sendKeys(textValue);
        Thread.sleep(3000);

        // Scroll to the text box
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", textField);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
