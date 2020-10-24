package com.tipico.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TrendsPage {
     WebDriver driver;

   @FindBy(xpath = ".//input[@id='input-254']")
   public WebElement Searchbox;

    public TrendsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     public void OpenPage() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
      public ExplorePage EnterSearchTerm(){
            Searchbox.sendKeys("Selenium Webdriver"+ Keys.ENTER);

       ExplorePage explorePg=new ExplorePage(driver);
        return explorePg;
    }
}
