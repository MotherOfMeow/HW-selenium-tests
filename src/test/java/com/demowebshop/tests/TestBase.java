package com.demowebshop.tests;

import com.demowebshop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", Browser.CHROME.browserName())
    );

    @BeforeClass
    public String getTestData() {
        return app.generateEmail();
    }

    @BeforeMethod
    public void startTest(Method method) {
        app.init();
        logger.info("Start test " + method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod()
                    .getMethodName() + " Screenshot path: " + app.getUser()
                    .takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("*********************************************************");
        app.stop();
    }
}
