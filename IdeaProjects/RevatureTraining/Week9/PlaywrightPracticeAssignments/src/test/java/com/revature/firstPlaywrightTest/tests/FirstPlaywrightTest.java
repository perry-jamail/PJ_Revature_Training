package com.revature.firstPlaywrightTest.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstPlaywrightTest {
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                .setHeadless(false)
                .setSlowMo(100)
        );
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = browser.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void testNavigateToHomepage() {
        page.navigate("https://the-internet.herokuapp.com/");

        assertThat(page).hasTitle("The Internet");

        Locator heading = page.locator("h1");
        assertThat(heading).containsText("Welcome to the-internet");
    }

    @Test
    void testClickNavigationLink() {
        page.navigate("https://the-internet.herokuapp.com/");

        page.click("text=Form Authentication");

        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");

        assertThat(page.locator("h2")).hasText("Login Page");
    }

    @Test
    void testFormInteraction() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.fill("#username", "tomsmith");
        page.fill("#password", "SuperSecretPassword!");
        page.click("button[type='submit']");

        assertThat(page).hasURL(Pattern.compile(".*/secure"));
        assertThat(page.locator("#flash")).containsText("You logged into");
    }

    @Test
    void testAutoWaitBehavior() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1");

        page.click("#start button");

        Locator result = page.locator("#finish h4");

        assertThat(result).hasText("Hello World!");
    }

    @Test
    void testLocatorStrategies() {
        page.navigate("https://the-internet.herokuapp.com/login");

        Locator byId = page.locator("#username");
        assertThat(byId).isVisible();

        Locator byCss = page.locator("input[name='password']");
        assertThat(byCss).isVisible();

        Locator byRole = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Login"));
        assertThat(byRole).isVisible();

        Locator byPlaceholder = page.getByPlaceholder("username");
    }
}
