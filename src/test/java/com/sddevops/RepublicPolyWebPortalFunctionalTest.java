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
        WebElement webElement = webDriver.findElement(By.id("main-banner"));
        WebElement slickListDraggableWebElement = webElement.findElement(By.className("slick-list"));
        WebElement slickTrackWebElement = slickListDraggableWebElement.findElement(By.className("slick-track"));

        // Get attribute role of WebElement
        String attribute = slickTrackWebElement.getAttribute("role");

        // AssertEquals that WebElement's role attribute is equals listbox
        Assert.assertEquals(attribute, "listbox");
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

    @Test
    public void findByCSSSelector(){

        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);


        // Navigate to practice website
        webDriver.navigate().to(TEST_URL);



        // Find WebElement by css selector img and title=Republic Polytechnic
        WebElement wrapperWebElement = webDriver.findElement(By.id("wrapper"));

        WebElement headerWebElement = wrapperWebElement.findElement(By.id("header"));

        WebElement sfContentBlockWebElement = headerWebElement.findElement(By.className("sfContentBlock"));

        WebElement rpHeaderWebElement = sfContentBlockWebElement.findElement(By.className("rp-header"));

        WebElement containerWebElement = rpHeaderWebElement.findElement(By.className("container"));

        WebElement rowWebElement = containerWebElement.findElement(By.className("row"));

        WebElement colMdWebElement = rowWebElement.findElement(By.className("col-md-2"));

        WebElement rpLogoWebElement = colMdWebElement.findElement(By.className("rp-logo"));

        WebElement aWebElement = rpLogoWebElement.findElement(By.tagName("a"));

        WebElement imgWebElement = aWebElement.findElement(By.tagName("img"));

        String title = imgWebElement.getAttribute("title");

        // Assert Equals that WebElement title is Republic Polytechnic
        Assert.assertEquals(title, "Republic Polytechnic");
    }

}
