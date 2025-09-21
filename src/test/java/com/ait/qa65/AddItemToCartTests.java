package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("rotTest@gmail.com").setPassword("HW123!"));
        clickOnLoginButton();
    }
    
    @Test
    public void addItemPositiveTest() {
        clickAddToCartButton();
        clickOnShoppingCartLink();
        Assert.assertTrue(isProductNamePresent());
        pause(10);
        Assert.assertEquals(getProductName().trim(), "14.1-inch Laptop");
    }

    @AfterMethod
    public void postcondition(){
        clearCart();
    }
}
