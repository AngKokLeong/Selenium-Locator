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
import java.util.List;

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

    @Test
    public void findByName(){
        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);

        // Find WebElement by Name: keywords
        WebElement webElementByName = webDriver.findElement(By.name("keywords"));

        // Get Attribute content of WebElement
        String content = webElementByName.getAttribute("content");

        // AssertTrue that WebElement's content attribute contains the following String "Republic Polytechnic"
        Assert.assertTrue(content.contains("Republic Polytechnic"));
    }

    @Test
    public void findByClassName(){

        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);

        // Find List<WebElement> by class name: hover
        List<WebElement> webElementList = webDriver.findElements(By.className("hover"));

        // Get size of List<WebElement> using the size function
        Integer webElementListSize = webElementList.size();

        // AssertEquals that List<WebElement> is equal to 7
        Assert.assertEquals(webElementListSize, 7);
    }

    @Test
    public void testHomeSearch(){

        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);

        // Find WebElement by Class Name: collapsed
        WebElement webElementCollapsed = webDriver.findElement(By.className("collapsed"));

        // Click on WebElement
        webElementCollapsed.click();

        // Find 2nd WebElement by Class Name: homesearch
        WebElement webElementHomeSearch = webDriver.findElement(By.className("homesearch"));

        // send keys "devops" to 2nd WebElement
        webElementHomeSearch.sendKeys("devops");

        // send keys "Keys.ENTER" to 2nd WebElement
        webElementHomeSearch.sendKeys("Keys.ENTER");
    }



}
