package com.sddevops;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.nio.file.*;

public class RepublicPolyWebPortalFunctionalTest {
    
    private WebDriver webDriver;
    private static String TEST_URL = "https://www.rp.edu.sg";


    @BeforeTest
    public void beforeTest(){
        Path path = Paths.get("/Users/angkokleong/Desktop/chromedriver");

        System.setProperty("webdriver.chrome.driver", path.toString());

        webDriver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }


    @Test
    public void findById(){
        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);

        // Find WebElement by Id: content
        WebElement webElement = webDriver.findElement(By.id("content"));

        // Get attribute role of WebElement
        String attribute = webElement.getAttribute("role");

        // AssertEquals that WebElement's role attribute is equals toolbar
        Assert.assertEquals(attribute, "toolbar");
    }



}
