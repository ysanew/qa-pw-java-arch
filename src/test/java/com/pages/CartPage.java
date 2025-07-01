package com.pages;

import com.components.HeaderComponent;
import com.microsoft.playwright.Locator;
import com.models.ShipInfo;
import io.qameta.allure.Step;

public final class CartPage extends BasePage {
    private HeaderComponent headerComponent;

    @Override
    public void initComponents() {
        headerComponent = new HeaderComponent(page);
    }

    @Step("Get items names")
    public Locator getItems() {
        return page.locator("//div[@class='cart_list']//div[@class='inventory_item_name']");
    }

    @Step("Click on checkout button")
    public CartPage clickOnCheckout() {
        page.locator("//button[@data-test='checkout']").click();
        return this;
    }

    @Step("Fill ship information <shipInfo>")
    public CartPage fillInfo(ShipInfo shipInfo) {
        page.fill("//input[@data-test='firstName']", shipInfo.getFirstName());
        page.fill("//input[@data-test='lastName']", shipInfo.getLastName());
        page.fill("//input[@data-test='postalCode']", shipInfo.getZip());
        return this;
    }

    @Step("Click continue button")
    public CartPage clickOnContinue(){
        page.locator("//input[@data-test='continue']").click();
        return this;
    }

    @Step("Get complete header")
    public Locator getCompleteHeader() {
        return page.locator("//h2[@data-test='complete-header']");
    }

    @Step("Click finish button")
    public CartPage clickOnFinish(){
        page.locator("//button[@data-test='finish']").click();
        return this;
    }
}
