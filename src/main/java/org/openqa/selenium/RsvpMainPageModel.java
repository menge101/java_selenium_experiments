package org.openqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.List;

public class RsvpMainPageModel {
    private HashMap<String, By> pageElements;

    RsvpMainPageModel() {
        pageElements = new HashMap<String, By>();
        pageElements.put("invitationForm", By.id("registrar"));
        pageElements.put("invite_text_field", By.name("name"));
        pageElements.put("submit", By.name("submit"));
        pageElements.put("inviteeList", By.cssSelector("#invitedList li"));
        pageElements.put("inviteeName", By.cssSelector("span"));
        pageElements.put("inviteeEditableName", By.cssSelector("input"));
        pageElements.put("inviteeSaveBtn", By.cssSelector("input + label + button"));
        pageElements.put("inviteeConfirm", By.cssSelector("label input"));
        pageElements.put("inviteeEditBtn", By.xpath("*/button[1]"));
        pageElements.put("inviteeRemoveBtn", By.cssSelector("button:last-child"));
    }

    public WebElement find(String elementName, WebDriver driver) {
        return driver.findElement(pageElements.get(elementName));
    }

    public List<WebElement> findElements(String elementName, WebDriver driver) {
        return driver.findElements(pageElements.get(elementName));
    }

    public WebElement findChildElement(String elementName, WebElement parent) {
        return parent.findElement(pageElements.get(elementName));
    }

    public List<WebElement> findChildElements(String elementName, WebElement parent) {
        return parent.findElements(pageElements.get(elementName));
    }
}
