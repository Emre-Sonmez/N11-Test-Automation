package test;

import Pages.BasketPage;
import Pages.HeaderPage;
import Pages.LoginPage;
import base.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MyTest extends BaseTest {
    Logger LOGGER = Logger.getLogger(MyTest.class);
    LoginPage loginPage;
    HeaderPage headerPage;
    BasketPage basketPage;

    @Test

    public void N11_Test()
    {
        loginPage = new LoginPage();
        headerPage = new HeaderPage();
        basketPage =new BasketPage();

        loginPage.login();
        headerPage.searchData();
        headerPage.goSecondPage();
        basketPage.addBasketAndPriceControl();
        basketPage.raiseNumberProduct();
        basketPage.deleteProduct();
        loginPage.logout();


    }

}
