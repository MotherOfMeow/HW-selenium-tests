package com.ait.qa65;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demowebshop.tricentis.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void openGoogleTest() {
        String title = driver.getTitle();
        assert title != null && title.contains("Demo Web Shop");
    }

    @Test
    public void findSomeElementsTest() {
        driver.findElement(By.cssSelector(".header-logo"));
        driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(1)"));
        driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(2)"));
        driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(3)"));
        driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(4)"));
        driver.findElement(By.xpath("//*[@id=\"pollanswers-1\"]"));
        driver.findElement(By.id("newsletter-email"));
        driver.findElement(By.id("newsletter-subscribe-button"));
        driver.findElement(By.xpath("//*[@id=\"vote-poll-1\"]"));
        driver.findElement(By.cssSelector(".column.customer-service"));
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
