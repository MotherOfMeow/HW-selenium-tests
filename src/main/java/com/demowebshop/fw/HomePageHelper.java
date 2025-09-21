package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        String title = getTitle();
        return title != null && title.contains("Demo Web Shop");
    }
}
