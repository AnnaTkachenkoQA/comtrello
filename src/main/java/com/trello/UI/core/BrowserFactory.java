package com.trello.UI.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {

    private Logger logger = LoggerFactory.getLogger(BrowserFactory.class);
    private  static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        logger.info("Browser started");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();//убивает процесс close - закрывает вкладку
        logger.info("Browser closed");
    }


    public static WebDriver driver() {
        return driver;
    }


    public static  void get(String url) {
        driver().get(url);
    }

    public static WebDriverWait getWebDriverWait(long timeout){

        return new WebDriverWait(driver(),timeout);
    }

}
