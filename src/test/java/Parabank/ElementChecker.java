package Parabank;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementChecker {

    private WebDriver driver;
    private WebDriverWait wait;
    private Map<Integer, Integer> responseCodeCount;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        responseCodeCount = new HashMap<>();
    }

    @Test
    public void checkElementsOnPage() {
        Reporter.log("Navigating to the Parabank page", true);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Count and check all links
        Reporter.log("Fetching and checking all links on the page", true);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }

        // Count and check all images
        Reporter.log("Fetching and checking all images on the page", true);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        int imageCount = images.size();
        for (WebElement img : images) {
            String url = img.getAttribute("src");
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }
        Reporter.log("Total number of images: " + imageCount, true);

        // Count and check all buttons
        Reporter.log("Fetching and checking all buttons on the page", true);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        int buttonCount = buttons.size();
        for (WebElement button : buttons) {
            if (!button.isDisplayed() || !button.isEnabled()) {
                Reporter.log("Broken button found: " + button.getText(), true);
            } else {
                Reporter.log("Valid button: " + button.getText(), true);
            }
        }
        Reporter.log("Total number of buttons: " + buttonCount, true);

        // Count and check all checkboxes
        Reporter.log("Fetching and checking all checkboxes on the page", true);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        int checkboxCount = checkboxes.size();
        Reporter.log("Total number of checkboxes: " + checkboxCount, true);

        // Count and check all textboxes
        Reporter.log("Fetching and checking all textboxes on the page", true);
        List<WebElement> textboxes = driver.findElements(By.cssSelector("input[type='text']"));
        int textboxCount = textboxes.size();
        Reporter.log("Total number of textboxes: " + textboxCount, true);

        // Count and check all combo boxes
        Reporter.log("Fetching and checking all combo boxes on the page", true);
        List<WebElement> comboBoxes = driver.findElements(By.tagName("select"));
        int comboBoxCount = comboBoxes.size();
        Reporter.log("Total number of combo boxes: " + comboBoxCount, true);

        // Count and check all date-time pickers
        Reporter.log("Fetching and checking all date-time pickers on the page", true);
        List<WebElement> dateTimePickers = driver.findElements(By.cssSelector("input[type='date']"));
        int dateTimePickerCount = dateTimePickers.size();
        Reporter.log("Total number of date-time pickers: " + dateTimePickerCount, true);

        // Report the counts of response codes
        Reporter.log("Counts of response codes found on the page:", true);
        for (Map.Entry<Integer, Integer> entry : responseCodeCount.entrySet()) {
            Reporter.log("Response Code " + entry.getKey() + ": " + entry.getValue(), true);
        }

        // Assert to ensure at least one link with 200 response code is present
        Assert.assertTrue(responseCodeCount.getOrDefault(200, 0) > 0, "There should be at least one link with 200 response code");
    }

    private void checkLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            responseCodeCount.put(responseCode, responseCodeCount.getOrDefault(responseCode, 0) + 1);

            if (responseCode >= 400) {
                Reporter.log("Broken link found: " + url + " - Response Code: " + responseCode, true);
            } else {
                Reporter.log("Valid link: " + url + " - Response Code: " + responseCode, true);
            }

        } catch (IOException e) {
            Reporter.log("Exception while checking link: " + url + " - Exception: " + e.getMessage(), true);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
