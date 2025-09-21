package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isItemNamePresent() {
        return isElementPresent(
                By.cssSelector(".product-name")
        );
    }

    public String getItemName() {
        return getText(By.cssSelector(".product-name"));
    }
}
