package com.revature.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Finding Elements")
public class Test02FindElements {

    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

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

    @DisplayName("Test by Id")
    @Test
    public void testById(){
        driver.get(BASE_URL + "/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        assertTrue(username.isDisplayed());
        assertTrue(password.isDisplayed());
    }

    @DisplayName("Test by name")
    @Test
    public void testByName(){
        driver.get(BASE_URL + "/login");
        WebElement name = driver.findElement(By.name("login"));

        assertTrue(name.isDisplayed());
    }

    @DisplayName("Test by TagName")
    @Test
    public void testByTag(){
        driver.get(BASE_URL + "/login");
        List<WebElement> tags = driver.findElements(By.tagName("input"));

        for (WebElement tag : tags) {
            System.out.println(tag);
            assertTrue(tag.isDisplayed());
        }
    }

    @DisplayName("Test Login Button")
    @Test
    public void testLoginButton(){
        driver.get(BASE_URL + "/login");
        WebElement btn = driver.findElement(By.className("radius"));

        System.out.println(btn.getText());
        assertEquals("Login", btn.getText());
    }

    @DisplayName("Absolute Xpath")
    @Test
    public void testAbsoluteXpath(){
        driver.get(BASE_URL);
        WebElement txt = driver.findElement(By.xpath("/html/body/div[2]/div/h2"));

        System.out.println(txt.getText());
        assertTrue(txt.getText().contains("Available"));
    }

    @DisplayName("Relative Xpath")
    @Test
    public void testRelativeXpath(){
        driver.get(BASE_URL);
        WebElement txt = driver.findElement(By.xpath("//h2[contains(text(),'Available')]"));

        System.out.println(txt.getText());
        assertTrue(txt.getText().contains("Available"));
    }

    @DisplayName("Test Login Using Valid Credentials")
    @Test
    public void testLoginValid() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.className("radius"));

        username.clear();
        password.clear();

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        btn.click();

        Thread.sleep(5000);

        WebElement flash = driver.findElement(By.xpath("//div[@id='flash']"));
        String flashText = flash.getText();

        assertEquals("https://the-internet.herokuapp.com/secure",  driver.getCurrentUrl());
        assertTrue(flashText.contains("You logged into a secure area!"));
    }
}
