package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class TestPW04 {
    @DisplayName("Screenshot Demo")
    @Test
    public void testScreenshots() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            page.navigate("https://playwright.dev/");

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("screenshot.png")));

//            page.locator(".hero hero--primary heroBanner_UJJx").screenshot(new Locator.ScreenshotOptions()
//                    .setPath(Paths.get("src/test/resources/screenshot.png")));
        }
    }

    @DisplayName("PW Video Recording")
    @Test
    public void testVideo() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );

            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setRecordVideoDir(Paths.get("target/videos/"))
                            .setRecordVideoSize(1280, 720)
            );

            Page page = browser.newPage();
            System.out.println("Recording Started");

            page.navigate("https://the-internet.herokuapp.com/login");

            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator(".radius").click();

            context.close();

            browser.close();
        }
    }
}
