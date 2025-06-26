package com.components;

import com.microsoft.playwright.Page;

public final class SideNavMenuComponent extends BaseComponent{

    public SideNavMenuComponent(final Page page) {
        super(page);
    }

    public void clickOnLogout() {
        page.click("#logout_sidebar_link");
    }
}
