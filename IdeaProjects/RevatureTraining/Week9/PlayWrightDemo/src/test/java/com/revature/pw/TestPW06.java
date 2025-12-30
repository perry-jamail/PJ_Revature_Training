package com.revature.pw;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

@DisplayName("Visual Test Demo")
public class TestPW06 {

    @DisplayName("Visual Demo")
    @Test
    public void testVisuals() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/login");

            page.waitForLoadState(LoadState.NETWORKIDLE);

            Path baselinePath = Paths.get("target/visual-tests/baseline/login-page.png");

//            page.screenshot(
//                new Page.ScreenshotOptions()
//                        .setPath(baselinePath)
//            );

            Path currentePath = Paths.get("target/visual-tests/current/login-page.png");

            page.screenshot(
                    new Page.ScreenshotOptions()
                        .setPath(currentePath)
            );
        }
    }
}
