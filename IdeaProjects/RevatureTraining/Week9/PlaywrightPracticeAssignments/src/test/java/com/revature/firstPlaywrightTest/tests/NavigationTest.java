package com.revature.firstPlaywrightTest.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createPage() {
        context = browser.newContext();
        page = browser.newPage();
    }

    @AfterEach
    void closePage() {
        context.close();
    }

    @Test
    void testBackForwardNavigation() {
        page.navigate("https://the-internet.herokuapp.com/");
        String homeUrl = page.url();

        page.click("text=Form Authentication");
        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");

        page.goBack();
        assertThat(page).hasURL(homeUrl);

        page.goForward();
        assertThat(page).hasURL("https://the-internet.herokuapp.com/login");
    }

    @Test
    void testNewTab() {
        page.navigate("https://the-internet.herokuapp.com/windows");

        Page popup = page.waitForPopup(() -> {
            page.click("text=Click Here");
        });

        assertThat(popup).hasTitle("New Window");
        assertThat(popup.locator("h3")).hasText("New Window");

        popup.close();
    }

    @Test
    void testMultipleTabs() {
        page.navigate("https://the-internet.herokuapp.com/");

        Page page2 = context.newPage();
        page2.navigate("https://the-internet.herokuapp.com/login");

        assertThat(page).hasTitle("The Internet");
        assertThat(page2).hasURL("https://the-internet.herokuapp.com/login");

        page2.close();
    }

    @Test
    void testWaitForNavigation() {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.fill("#username", "tomsmith");
        page.fill("#password", "SuperSecretPassword!");
        page.click("button[type='submit']");
        page.waitForURL("**/secure");

        assertThat(page.locator("#flash")).containsText("secure area");
    }

    @Test
    void testCaptureScreenshot() {
        page.navigate("https://the-internet.herokuapp.com/");

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("src/test/resources/screenshots/homepage.png"))
                .setFullPage(true)
        );

        Locator heading = page.locator("h1");
        heading.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("src/test/resources/screenshots/heading.png"))
        );

        File fullPage = new File("src/test/resources/screenshots/homepage.png");
        File element = new File("src/test/resources/screenshots/heading.png");

        assertTrue(fullPage.exists(), "Full page screenshot should exist");
        assertTrue(element.exists(), "Element screenshot should exist");
    }
}
