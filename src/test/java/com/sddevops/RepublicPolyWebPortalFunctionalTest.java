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

}
