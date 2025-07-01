package com.pages;

import com.components.HeaderComponent;
import com.components.SideNavMenuComponent;
import com.microsoft.playwright.Locator;
import com.utils.BasePageFactory;
import io.qameta.allure.Step;

public final class ProductsPage extends BasePage {

    private HeaderComponent header;
    private SideNavMenuComponent sideNavMenu;

    @Override
    public void initComponents() {
        header = new HeaderComponent(page);
        sideNavMenu = new SideNavMenuComponent(page);
    }

    @Step("Get title of the 'Products' page")
    public Locator getTitle() {
        return page.locator(".title");
    }

    @Step("Get all products names")
    public Locator getProductNames() {
        return page.locator("//div[@data-test='inventory-item-name']");
    }

    @Step("Set <sortName> into 'Sort Filter'")
    public ProductsPage setSortFilter(String sortName){
        page.locator("//select[@data-test='product-sort-container']").selectOption(sortName);
        return this;
    }

    @Step("Add to cart item with name <itemName>")
    public ProductsPage addItemToCart(String itemName){
        page.locator(String.format("//div[text()='%s']//following::button[1]", itemName)).click();
        return this;
    }

    @Step("Click on Cart button")
    public CartPage clickOnCart() {
        header.clickOnCart();
        return BasePageFactory.createInstance(CartPage.class, page);
    }

    @Step("Click on 'Logout' button from side navigation menu")
    public LoginPage clickOnLogout() {
        header.clickOnHamburgerMenu();
        sideNavMenu.clickOnLogout();

        return BasePageFactory.createInstance(LoginPage.class, page);
    }

}