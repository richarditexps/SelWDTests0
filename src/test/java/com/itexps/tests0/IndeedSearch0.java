/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.tests0;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;  //Junit
import static org.junit.Assert.*; //Junit Assert
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IndeedSearch0 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "c:\\qa\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
   // baseUrl = "https://www.google.com/";  //change this to indeed.com
    baseUrl = "https://www.indeed.com/";  //changed this to indeed.com
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIndeedSearch0() throws Exception {
    //driver.get("https://indeed.com");
    driver.get(baseUrl);
    
    assertTrue(driver.getTitle().contains("Job Search | Indeed"));
    driver.findElement(By.id("text-input-what")).clear();
    driver.findElement(By.id("text-input-what")).sendKeys("selenium");
    
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertTrue(driver.getTitle().contains("Selenium Jobs, Employment in Naperville, IL | Indeed.com"));
   //assertTrue(driver.find Element(By name(""));
//assertTrue(driver.findElements(By.xpath("//input[@type='Naperville']")).size()!= 0);
    //assertTrue(isTextPresent("Naperville"));
    //assertTrue(driver.findElement(By.name("Naperville")));
    //assertTrue(driver.getTitle().contains("QA Automation Engineer"));

  }

  @After
  public void tearDown() throws Exception {
    // driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

 

