package com.demowebshop.tests;

import com.demowebshop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase{
    protected ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", Browser.CHROME.browserName())
    );

    @BeforeClass
    public String getTestData() {
        return app.generateEmail();
    }

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
