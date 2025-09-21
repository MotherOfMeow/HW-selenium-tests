package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("a[href=\"/register\"]"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public void fillRegisterForm(User user) {
        click(By.id("gender-female"));
        type(By.xpath("//*[@id=\"FirstName\"]"), user.getFirstName());
        type(By.xpath("//*[@id=\"LastName\"]"), user.getLastName());
        type(By.xpath("//*[@id=\"Email\"]"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//*[@id=\"Email\"]"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
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
}
