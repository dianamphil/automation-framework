package com.tipico.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ExplorePage {
    public WebDriver driver;

    @FindBy(xpath = ".//*[contains(text(),'Compare')]")
    private WebElement Compare;

    public ExplorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComparePage CompareTerms(){
       ((JavascriptExecutor) driver).executeScript("arguments[0].click()", Compare);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(Compare).sendKeys("Javascript WebDriverIO").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        ComparePage comparePg=new ComparePage(driver);
        return comparePg;
    }
}
