package fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;
    UserHelper user;
    CartHelper cart;
    ItemHelper item;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        item = new ItemHelper(driver);
        cart = new CartHelper(driver);
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
}
