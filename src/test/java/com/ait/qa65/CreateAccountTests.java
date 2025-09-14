package com.ait.qa65;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
//        click register
        driver.findElement(By.cssSelector("[href='/register']"));
//        choose female
        driver.findElement(By.id("gender-female"));
//        fill first name
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("John");
//        fill last name
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Doe");
//        fill email
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("hw-test-user@gmail.com");
//        fill password
        driver.findElement(By.name("Password")).sendKeys("HW123!");
//        confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("HW123!");
//        click Register button
        driver.findElement(By.id("register-button")).click();
    }

    @Test
    public void newUserRegistrationNegativeTest() {
//        click register
        driver.findElement(By.cssSelector("[href='/register']"));
//        choose female
        driver.findElement(By.id("gender-female"));
//        fill first name
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("John");
//        fill last name
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Doe");
//        fill email
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("hw-test-user@gmail.com");
//        fill password
        driver.findElement(By.name("Password")).sendKeys("HW123!");
//        confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("HW123!");
//        click Register button
        driver.findElement(By.id("register-button")).click();
    }
}
