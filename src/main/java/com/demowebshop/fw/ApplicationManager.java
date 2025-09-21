package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    UserHelper user;
    CartHelper cart;
    ItemHelper item;
    HomePageHelper home;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else  if(browser.equalsIgnoreCase("safari")){
            driver= new SafariDriver();
        }
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        item = new ItemHelper(driver);
        cart = new CartHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public String generateEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        return "hw-test-user" + i + "@gmail.com";
    }

    public UserHelper getUser() {
        return user;
    }

    public CartHelper getCart() {
        return cart;
    }

    public ItemHelper getItem() {
        return item;
    }

    public HomePageHelper getHome() {return home;}
}
