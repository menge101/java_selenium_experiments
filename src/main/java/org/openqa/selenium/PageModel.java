package org.openqa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public abstract class PageModel {
    private HashMap<String, By> elements;

    PageModel() {
        elements = new HashMap<String, By>();
    }

    public void addElement(String name, By matcher) {
        elements.put(name, matcher);
    }

    public WebElement find(String elementName, WebDriver driver) {
        return driver.findElement(elements.get(elementName));
    }

    public List<WebElement> findElements(String elementName, WebDriver driver) {
        return driver.findElements(elements.get(elementName));
    }

    public WebElement findChildElement(String elementName, WebElement parent) {
        return parent.findElement(elements.get(elementName));
    }

    public List<WebElement> findChildElements(String elementName, WebElement parent) {
        return parent.findElements(elements.get(elementName));
    }
}
