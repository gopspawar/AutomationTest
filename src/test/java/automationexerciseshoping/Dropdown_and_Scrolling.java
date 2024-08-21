package automationexerciseshoping;

import java.awt.print.Printable;
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

public class Dropdown_and_Scrolling {
		
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    
	    @BeforeClass
	    public void setUp()
	    {
	    	WebDriverManager.chromedriver().setup();
	    	
	    	driver = new ChromeDriver();
	        
	    	driver.manage().window().maximize();
	    	
	    	
	    	//Explicite wait
	    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    
	    @Test (priority = 1)
	    public void CourseNamedropDownFunctionality() {
	    	driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
	    }
	    
	    @Test (priority = 2)
	    public void checkjavaSelected()
	    {
	    	Reporter.log("Verify that selct Dropdown and select Java",true);
	    	WebElement DropDownElement = driver.findElement(By.xpath("//select[@id='course']"));
	    	Select s = new Select(DropDownElement);
	    	s.selectByVisibleText("Java");
	    	
	    	String SelectedOption = s.getFirstSelectedOption().getText();
	    	System.out.println("Selected 1st Option: "+SelectedOption);
	    	
	    	//s.selectByIndex(0);
	    	//s.selectByValue("");
	    }	
	    @Test(priority=3)
	    public void checkPythonSelected() {    
	        Reporter.log("Verify that select Dropdown and select Python", true);
	        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='course']"));
	        
	        Select s = new Select(dropDownElement);
	        s.selectByVisibleText("Python");
	        
	        // Get the selected option and print it to the console
	        String selectedOption = s.getFirstSelectedOption().getText();
	        System.out.println("Selected 2nd option: " + selectedOption);
	    }

	    
	    @Test(priority=4)
	    public void checkJavaScript()
	    {
	    	Reporter.log("Verify that select Dropdown and select javascript",true );
	    	try {
	    	WebElement DropDownElement = driver.findElement(By.xpath("//select[@id='course']"));
	    	
	    	Select s = new Select(DropDownElement);
	    	s.selectByVisibleText("Javascript");
	    	
	    	 Reporter.log("JavaScript selection in dropdown was successful", true);
	    	 // Get the selected option and print it to the console
	    	 String selectedOption = s.getFirstSelectedOption().getText();
	    	 System.out.println("Selected 3rd Options: "+selectedOption);
	    	 
	        } catch (Exception e) {
	            Reporter.log("Failed to select JavaScript from the dropdown: " + e.getMessage(), true);
	            e.printStackTrace();
	    	}
	    
	    }
	    	
	    @AfterClass
	    public void tearDown() 
	    	{
	    		if(driver != null) {
	    			driver.quit();
	    		}
	    	}
	    }














