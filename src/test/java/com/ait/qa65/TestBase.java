package com.ait.qa65;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public String generateEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        return "hw-test-user" + i + "@gmail.com";
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("a[href=\"/register\"]"));
    }

    public void fillRegisterLoginForm(User user) {
        click(By.id("gender-female"));
        type(By.xpath("//*[@id=\"FirstName\"]"), user.getFirstName());
        type(By.xpath("//*[@id=\"LastName\"]"), user.getLastName());
        type(By.xpath("//*[@id=\"Email\"]"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public boolean isSuccessMessagePresent() {
        return isElementPresent(
                By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")
        );
    }

    public boolean isUnsuccessMessagePresent() {
        return isElementPresent(
                By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")
        );
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
