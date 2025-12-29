package com.revature.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPW03 extends TestPW02 {
    @Test
    void login_success() {
        navigateTo("/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator(".radius").click();

        assertThat(page).hasURL(Pattern.compile(".*secure"));
        assertThat(page.locator("#flash")).containsText("You logged into a secure area!");
    }

    @Test
    void login_failure() {
        navigateTo("/login");

        page.locator("#username").fill("wrongusername");
        page.locator("#password").fill("wrongpassword");
        page.locator(".radius").click();

        assertThat(page.locator("#flash")).isVisible();
        assertThat(page.locator("#flash")).containsText("is invalid!");
    }

    @Test
    void demoLocators() {
        navigateTo("/login");

        Locator byId = page.locator("#username");

        Locator byClass = page.locator(".radius");

        Locator byRole = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));

        Locator byPlaceholder = page.getByPlaceholder("User name");

        Locator byLabel = page.getByLabel("Password");
    }
}
