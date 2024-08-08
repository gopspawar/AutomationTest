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

public class verifybrokenlinksparabank {

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
    public void checkBrokenLinks() {
        Reporter.log("Navigating to the Parabank page", true);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        Reporter.log("Fetching all links on the page", true);
        // Fetch all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }

        // Report the counts of response codes
        for (Map.Entry<Integer, Integer> entry : responseCodeCount.entrySet()) {
            Reporter.log("Response Code " + entry.getKey() + ": " + entry.getValue(), true);
        }

        // Assertions for specific status codes if needed
        Assert.assertTrue(responseCodeCount.getOrDefault(200, 0) > 0, "There should be at least one link with 200 response code");
        Assert.assertTrue(responseCodeCount.getOrDefault(301, 0) > 0, "There should be at least one link with 301 response code");
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
                Assert.fail("Broken link found: " + url + " - Response Code: " + responseCode);
            } else {
                Reporter.log("Valid link: " + url + " - Response Code: " + responseCode, true);
            }

        } catch (IOException e) {
            Reporter.log("Exception while checking link: " + url + " - Exception: " + e.getMessage(), true);
            Assert.fail("Exception while checking link: " + url + " - Exception: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
