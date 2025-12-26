package com.revature.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Basic Selenium Test")
public class Test01SelBasics {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        // Set up your WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize your WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBasic() throws InterruptedException {
        // Navigate to the website
        driver.get("https://www.selenium.dev/");
        Thread.sleep(5000);

        // Get the page Title
        String title = driver.getTitle();
        System.out.println(title);

        assertTrue(title.contains("Selenium"));
    }

    @Test
    public void testContainsDocumentation() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation");
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        assertTrue(url.contains("documentation"));
    }
}
