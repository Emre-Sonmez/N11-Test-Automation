package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage  {

    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
    private Logger LOGGER = Logger.getLogger(BasePage.class);



    protected WebElement getElement(By byElement) {
        return driver.findElement(byElement);
    }

    protected WebElement waitForElement(By byElement) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

    protected void waitForElementAndClick(By byElement) {
        waitForElement(byElement).click();
    }

    protected void waitForElementAndSendKeys(By byElement, String text) {
        waitForElement(byElement).sendKeys(text);
    }

    protected String waitForElementAndGetText(By byElement) {
        return waitForElement(byElement).getText();
    }

    protected String waitForElementAndGetAttribute(By byElement, String attribute) {
        return waitForElement(byElement).getAttribute(attribute);
    }

    protected List<WebElement> waitForElements(By byElement) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byElement));
    }

    protected void waitForElementsAndClickWithIndex(By byElement, int index) {
        waitForElements(byElement).get(index).click();
    }

    protected String waitForElementsAndGetTextWithIndex(By byElement, int index) {
        return waitForElements(byElement).get(index).getText();
    }

    protected void waitSeconds(int seconds) {
        try {
            LOGGER.info(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOGGER.info(e);
        }
    }

    public boolean isElementVisible(By element, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }







}
