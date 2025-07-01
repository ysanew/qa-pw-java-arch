package com.utils;

import com.microsoft.playwright.Page;
import com.pages.BasePage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class BasePageFactory {

    public static <T extends BasePage> T createInstance(final Class<T> clazz, final Page page) {
        try {
            BasePage instance = clazz.getDeclaredConstructor().newInstance();

            instance.setAndConfigurePage(page);
            instance.initComponents();

            return clazz.cast(instance);
        } catch (Exception e) {
            log.error("BasePageFactory::createInstance", e);
        }

        throw new NullPointerException("Page class instantiation failed");
    }
}
