package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestPW02 {
    static Playwright playwright;
    static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
    }

    @AfterAll
    public static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    public void beforeEach() {
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080)
        );
        page = context.newPage();
    }

    @AfterEach
    public void afterEach() {
        context.close();
    }

    protected void navigateTo(String path) {
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "https://the-internet.herokuapp.com");
        page.navigate(baseUrl + path);
    }
}
