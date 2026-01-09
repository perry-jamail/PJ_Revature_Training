package com.revature.FirstSeleniumTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest extends BaseTest {
    @DisplayName("Navigate to Google and verify title")
    @Test
    void testNavigateToGoogle() {
        driver.navigate().to("https://google.com");
        String title = driver.getTitle();
        assertTrue(title.contains("Google"), "Page title should contain 'Google'");
    }

    @DisplayName("Navigate to Example.com and verify content")
    @Test
    void testNavigateToExample() {
        driver.navigate().to("https://example.com");

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        assertEquals("Example Domain", title);
        assertTrue(currentUrl.contains("example.com"));

        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals("Example Domain", heading.getText());
    }

    @DisplayName("Navigate to practice site and find elements")
    @Test
    void testFindElements() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals("Welcome to the-internet", heading.getText());

        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        assertTrue(formAuthLink.isDisplayed());

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Available Examples"));
    }

//    @DisplayName("Navigate to Sudoku.com")
//    @Test
//    void testNavigateToSudoku() {
//        driver.get("https://sudoku.com/");
//        assertTrue(driver.getCurrentUrl().contains("sudoku"));
//    }

    @DisplayName("Fill and submit login form")
    @Test
    void testLoginForm() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(flashMessage.getText().contains("You logged into a secure area!"));
    }

    @DisplayName("Test invalid login")
    @Test
    void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement flashMessage = driver.findElement(By.id("flash"));
        assertTrue(flashMessage.getText().contains("Your username is invalid!"));
    }

    @DisplayName("Test form clearing")
    @Test
    void testFormClearing() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));

        usernameField.sendKeys("some text");
        assertEquals("some text", usernameField.getAttribute("value"));

        usernameField.clear();
        assertEquals("", usernameField.getAttribute("value"));

        usernameField.sendKeys("new text");
        assertEquals("new text", usernameField.getAttribute("value"));
    }

    @DisplayName("Test logout functionality")
    @Test
    void testLogout() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(flashMessage.getText().contains("You logged into a secure area!"));

        driver.findElement(By.cssSelector(".button.secondary.radius")).click();

        WebElement logoutFlashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(logoutFlashMessage.getText().contains("You logged out of the secure area!"));
    }

    @DisplayName("Test link clicking and navigation")
    @Test
    void testLinkClicking() {
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Checkboxes")).click();

        assertTrue(driver.getCurrentUrl().contains("checkboxes"));

        driver.navigate().back();

        assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
    }

    @DisplayName("Test checkbox interactions")
    @Test
    void testCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        assertEquals(2, checkboxes.size(), "Should find 2 checkboxes");

        WebElement checkbox1  = checkboxes.get(0);
        WebElement checkbox2  = checkboxes.get(1);

        assertFalse(checkbox1.isSelected());

        checkbox1.click();
        assertTrue(checkbox1.isSelected());
    }

    @DisplayName("Test getting element attributes")
    @Test
    void testGetAttributes() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));

        String id = usernameField.getAttribute("id");
        String type = usernameField.getAttribute("type");
        String name = usernameField.getAttribute("name");

        assertEquals("username", id);
        assertEquals("text", type);
        assertEquals("username", name);

        assertTrue(usernameField.isEnabled());
        assertTrue(usernameField.isDisplayed());
    }
}
