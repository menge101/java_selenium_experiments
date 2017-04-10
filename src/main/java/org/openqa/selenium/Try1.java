package org.openqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Try1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement we = driver.findElement(By.name("q"));
        we.sendKeys("Cheese!");
        we.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
