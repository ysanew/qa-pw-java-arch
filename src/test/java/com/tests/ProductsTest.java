package com.tests;

import com.models.ShipInfo;
import com.pages.CartPage;
import com.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsTest extends BaseTest {

    @Test
    public void testSuccessfulLogout() {
        loginPage.loginAs("standard_user", "secret_sauce")
                .clickOnLogout();
        assertThat(page).hasURL("https://www.saucedemo.com/");
    }

    @Test
    public void testSortItems() {
        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");

        assertThat(productsPage.getProductNames().first()).hasText("Sauce Labs Backpack");

        productsPage.setSortFilter("Name (Z to A)");

        assertThat(productsPage.getProductNames().first()).hasText("Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void testAddItemToCartAndBuy() {
        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");
        String firstItemName = productsPage.getProductNames().first().textContent();

        CartPage cartPage = productsPage.addItemToCart(firstItemName).clickOnCart();

        assertThat(cartPage.getItems()).containsText(firstItemName);

        ShipInfo shipInfo = ShipInfo.builder()
                .firstName("MyName")
                .lastName("MyLastname")
                .zip("123456")
                .build();

        cartPage.clickOnCheckout().fillInfo(shipInfo).clickOnContinue().clickOnFinish();

        assertThat(cartPage.getCompleteHeader()).hasText("Thank you for your order!");
    }
}