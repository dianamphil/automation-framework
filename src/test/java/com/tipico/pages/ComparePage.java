package com.tipico.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ComparePage {

    private WebDriver driver;

    @FindBy(xpath = ".//hierarchy-picker[@track-name='geoPicker']")
    private WebElement LocationPicker;

    @FindBy(xpath = "./html/body/div[2]/div[2]/div/header/div/div[3]/ng-transclude/div[3]/div/div/hierarchy-picker[1]/ng-include/div[2]/md-autocomplete/md-autocomplete-wrap/input")
    private WebElement LocationInputBox;

    @FindBy(xpath=".//md-option/div[contains(text(),'Past 90 days')]")
    private WebElement DateChoice;

    @FindBy(xpath=".//*[@class='progress-bar-multi-heat-volume']//parent::div")
    private WebElement ProgressBar;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void InputLocation(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LocationPicker.click();
        LocationInputBox.sendKeys("New York"+Keys.DOWN+Keys.ENTER+Keys.TAB+Keys.ENTER);
    }

    public void InputTimeFrame(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", DateChoice);
    }

    public void FinalComparison()
    {   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);
        actions.moveToElement(ProgressBar).perform();

        String seleniumPercent = (String) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('.tooltip-percentage-container .tooltip-percentage')[0].textContent.trim().slice(0,-1)");
        String javascriptPercent = (String) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('.tooltip-percentage-container .tooltip-percentage')[1].textContent.trim().slice(0,-1)");

        System.out.println("SELENIUM WEBDRIVER PERCENTAGE IS " + seleniumPercent);
        System.out.println("JAVASCRIPT WEBDRIVER PERCENTAGE IS " + javascriptPercent);
       Assert.assertEquals("Selenium Webdriver is NOT more popular than Javascript IO", Integer.valueOf(seleniumPercent) > Integer.valueOf(javascriptPercent), true);


    }

}
