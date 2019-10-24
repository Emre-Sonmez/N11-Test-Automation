package Pages;



import base.BasePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    public Actions action;

    public void login (){

        waitForElementAndClick(By.className("btnSignIn"));
        String actualTitle;
        actualTitle = driver.getTitle();
        Assert.assertTrue("anasayfada değilsiniz", actualTitle.equals("Giriş Yap - n11.com"));
        //LOGIN_PAGE
        //login user
        String email = "sonmezemre16@gmail.com";
        String password = "33561994Es";
        waitForElementAndSendKeys(By.id("email"), email);
        waitForElementAndSendKeys(By.id("password"), password);
        waitForElementAndClick(By.id("loginButton"));
        waitSeconds(1);
        String usernaame= waitForElementAndGetText(By.xpath("//a[@class='menuLink user']"));
        System.out.println("Profile username : "+usernaame);
        Assert.assertTrue("Login Başarısız.", waitForElementAndGetText(By.xpath("//a[@class='menuLink user']")).equals("Emre Sönmez"));

    }
    public void logout()
    {

        waitSeconds(3);
        action = new Actions(driver);
        WebElement logoutx = getElement(By.className("myAccount"));
        action.moveToElement(logoutx).clickAndHold().build().perform();
        waitForElementAndClick(By.className("logoutBtn"));
    }
}
