package com.pages;

import com.utils.BasePageFactory;
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

    @Step("Click on the 'Login' button")
    public ProductsPage submitLogin() {
        page.click("id=login-button");
        return BasePageFactory.createInstance(ProductsPage.class, page);
    }

    @Step
    public ProductsPage loginAs(String username, String password) {
        return open()
                .typeUsername(username)
                .typePassword(password)
                .submitLogin();
    }
}
