package com.pages;

import io.qameta.allure.Step;
import com.microsoft.playwright.Locator;

import static com.config.ConfigurationManager.config;

public final class LoginPage extends BasePage {

    @Step("Navigate to the login page")
    public LoginPage open() {
        page.navigate(config().baseUrl());
        return this;
    }

    @Step("Type <username> into the 'Username' field")
    public LoginPage typeUsername(final String username) {
        page.fill("id=username", username);
        return this;
    }

    @Step("Type <password> into the 'Password' field")
    public LoginPage typePassword(final String password) {
        page.fill("id=password", password);
        return this;
    }

    @Step("Get the error message")
    public Locator getErrorMessage() {
        return page.locator(".error-message-container h3");
    }
}
