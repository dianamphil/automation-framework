package com.tipico.test;


import com.tipico.pages.ComparePage;
import com.tipico.pages.ExplorePage;
import com.tipico.pages.TrendsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CompareTrendsTest{

    private WebDriver driver;

    @BeforeTest
    public void SetDriver(){
        //use Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana.philip\\IdeaProjects\\TechnicalTest\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://trends.google.com/trends/?geo=US");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void VerifyTrendsPageCanBeOpened() throws InterruptedException {
        TrendsPage trend = new TrendsPage(driver);
        trend.OpenPage();
        trend.EnterSearchTerm();
    }

    @Test(priority = 2)
    public void VerifyComparisonCanBeDone() throws InterruptedException {
        ExplorePage explore = new ExplorePage(driver);
        explore.CompareTerms();
    }

    @Test(priority = 3)
    public void VerifySeleniumIsGreater() throws InterruptedException {
        ComparePage comp = new ComparePage(driver);
        comp.InputLocation();
        comp.InputTimeFrame();
        comp.FinalComparison();
    }

    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }

}
