package Pages;

import base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


    public class BasketPage extends BasePage {
            Logger LOGGER = Logger.getLogger(BasePage.class);
                public Actions action;
        public void ifBasketNotEmpty()
        {

            action = new Actions(driver);
            WebElement basket = getElement(By.xpath("//a[@title='Sepetim']/i[@class='icon iconBasket']"));
            action.moveToElement(basket).clickAndHold().build().perform();

            if (isElementVisible(By.xpath("//div[@class='myBasketList']/ul/li[@class='column']"),15))
            {
                LOGGER.info("Sepet temizleniyor");
                waitForElementAndClick(By.linkText("Sepete Git"));
                waitSeconds(2);
                while (isElementVisible(By.xpath("//table[@class='productGroup']//span[@title='Sil']"),15))
                {

                    waitForElementAndClick(By.xpath("//table[@class='productGroup']//span[@title='Sil']"));
                    waitSeconds(1);

                }
                waitForElementAndClick(By.cssSelector("img[alt='Alışverişin Uğurlu Adresi']"));
            }

        }

    public void addBasketAndPriceControl()
    {

        int index = 2;
        waitForElementsAndClickWithIndex(By.xpath("//h3[@class='productName bold']"), index);
        String firstPrice= waitForElementAndGetText(By.xpath("//div[@class='proDetailArea']/div[@class='proDetail']//ins"));
        LOGGER.info("İlk fiyat "+firstPrice);
        waitForElementAndClick(By.xpath("//div[@class='container']//a[@title='Sepete Ekle']"));
        waitForElementAndClick(By.xpath("//div[@class='customMenu']/div[4]//a[@title='Sepete Git']"));
        String secondPrice = waitForElementAndGetText(By.xpath("//div[@class='dtl']/span[contains(text(),'Ürün Toplamı')]/parent::div/span[2]"));
        LOGGER.info("İkinci fiyat "+secondPrice);
        Assert.assertEquals("Ürün sayfasındaki fiyat ile sepetteki fiyat uyuşmuyor",firstPrice,secondPrice);


    }

    public void raiseNumberProduct()

    {

        waitForElementAndClick(By.cssSelector(".spinnerArrow.spinnerUp"));

        Assert.assertTrue("Ürün sayısı arttırıldığı doğrulanamadı ",waitForElementAndGetAttribute(By.xpath("//div[@class='spinnerField ']/input"),"value").equals("2"));
        LOGGER.info("Ürün sayısı arttırıldı. ");

    }

    public void deleteProduct()
    {

        waitForElementAndClick(By.xpath("//table[@class='productGroup']//span[@title='Sil']"));
        Assert.assertTrue("",isElementVisible(By.xpath("//h2[@class='title'][contains(text(),'Sepetiniz Boş')]"),10));
        LOGGER.info("Sepetin boşaltıldığı doğrulandı.");
    }




       }
