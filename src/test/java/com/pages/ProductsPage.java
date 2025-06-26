package com.pages;

import com.components.HeaderComponent;
import com.components.SideNavMenuComponent;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;


public final class ProductsPage extends BasePage {

    private HeaderComponent headerComponent;
    private SideNavMenuComponent sideNavMenuComponent;

    @Override
    public void initComponents() {
        headerComponent = new HeaderComponent(page);
        sideNavMenuComponent = new SideNavMenuComponent(page);
    }

    @Step("Get the title of of the 'Products' page")
    public Locator getTitle() {
        return page.locator(".title");
    }

    @Step("Get names of all products")
    public Locator getProductsNames() {
        return page.locator("//div[@data-test='inventory-item-name']");
    }

    @Step("Set <sortName> into 'Sort Filter'")
    public ProductsPage setSortFilter(String sortName) {
        page.locator("//select[@data-test='product-sort-container']").selectOption(sortName);
        return this;
    }

    @Step("Add to cart the item with the name <itemName>")
    public ProductsPage addItemToCart(String itemName) {
        page.locator(String.format("//div[text()='%s']//following::button[1]", itemName)).click();
        return this;
    }
}
