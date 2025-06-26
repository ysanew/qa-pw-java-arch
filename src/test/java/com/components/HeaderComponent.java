package com.components;

import com.microsoft.playwright.Page;

public final class HeaderComponent extends BaseComponent{

    public HeaderComponent(final Page page) {
        super(page);
    }

    public void clickOnHamburgerMenu() {
        page.click("#react-burger-menu-btn");
    }
}
