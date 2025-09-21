package com.ait.qa65;

import data.ItemData;
import data.UserData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }
    
    @Test
    public void addItemPositiveTest() {
        app.getCart().clickAddToCartButton();
        app.getCart().clickOnShoppingCartLink();
        Assert.assertTrue(app.getItem().isItemNamePresent());
        app.getItem().pause(10);
        Assert.assertEquals(app.getItem().getItemName().trim(), ItemData.itemNAME);
    }

    @AfterMethod
    public void postcondition(){
        app.getCart().clearCart();
    }
}
