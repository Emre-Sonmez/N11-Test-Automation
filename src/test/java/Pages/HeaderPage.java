package Pages;

import base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage{

    public Actions action;
    Logger LOGGER = Logger.getLogger(BasePage.class);

    public void searchData()
    {

        String searchKey = "Bilgisayar";
        waitForElementAndSendKeys(By.id("searchData"), searchKey);
        waitForElementAndClick(By.xpath("//a[@class='searchBtn']/span"));
        //SEARCH_RESULT
        //bilgisayar ile ilgili arama yapıldığı kontrol edildi.
        Assert.assertTrue("Beklenen arama sonuç sayfası açılamadı.", waitForElementAndGetText(By.xpath("//div[@class='resultText ']/h1")).equals(searchKey));  // SEARCH_RESULT_KONTROL

    }

    public void goSecondPage()
    {

        action = new Actions(driver);
        //2. sayfaya ilerle.
        WebElement secondPage = getElement(By.xpath("//div[@class='pagination']/a[text()='2']"));
        action.moveToElement(secondPage).click().build().perform();
        waitForElementAndClick(By.xpath("//div[@class='pagination']/a[text()='2']"));
        waitSeconds(1);
         //2. sayfada olduğumuz kontrol edildi.
        Assert.assertTrue("2. sayfa açılamadı.", waitForElementAndGetAttribute(By.xpath("//div[@class='pagination']/a[text()='2']"), "class").equals("active "));
        LOGGER.info("2.sayfaya gidildi. ");

    }}




