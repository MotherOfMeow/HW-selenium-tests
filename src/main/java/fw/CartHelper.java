package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {
    ItemHelper item = new ItemHelper(driver);

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        click(By.xpath(
                "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input"
        ));
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("a[href=\"/cart\"]"));
    }

    public void clearCart() {
        if(item.isItemNamePresent()){
            click(By.name("removefromcart"));
            click(By.name("updatecart"));
        }
    }
}
