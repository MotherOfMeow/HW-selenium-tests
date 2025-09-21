package com.ait.qa65;

import fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase{
    protected ApplicationManager app = new ApplicationManager();

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
