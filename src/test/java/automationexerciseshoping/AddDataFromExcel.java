package automationexerciseshoping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class AddDataFromExcel {
	
	public class EnterDataFromExcel 
	{
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
	    
	    @Test
	    public void loadData() throws EncryptedDocumentException, IOException {
	    	String path = "C:\\Users\\LENOVO\\Desktop\\Projects-20240229T130642Z-001\\Projects\\BCA application\\Test Cases\\Master\\UserRoles.xlsx";
	    	
	    	FileInputStream fileInput = new FileInputStream(path);
	    	
	    	String data = WorkbookFactory.create(fileInput).getSheet("UserRole").getRow(1).getCell(1).getStringCellValue();
	    	
	    	System.out.println(data);
	    }

	    @Test(priority = 2)
	    public void addTextInMainFrame() throws InterruptedException,EncryptedDocumentException, IOException {
	    	
            String path = "C:\\Users\\LENOVO\\Desktop\\Projects-20240229T130642Z-001\\Projects\\BCA application\\Test Cases\\Master\\UserRoles.xlsx";
	    	
	    	FileInputStream fileInput = new FileInputStream(path);
	    	
	    	String data = WorkbookFactory.create(fileInput).getSheet("UserRole").getRow(8).getCell(1).getStringCellValue();
	    	
	    	System.out.println("Take Input Data from Excel"+data);
	    	
	    	
	    	
	        WebElement textField = driver.findElement(By.xpath("//input[@id='name']"));
	        textField.sendKeys(data);
	        Thread.sleep(3000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", textField);
	    }

	    @AfterClass
	    public void tearDown() {
	    	if(driver != null) {
	    		driver.quit();
	    	}
	    }
	    
	}
}
