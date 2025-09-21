package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void isHomeComponentPresentPositiveTest() {
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }
}
