package org.openqa.selenium;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.RsvpMainPageModel;

import java.util.List;


public class LaunchRsvp {
    public static void main(String[] args) throws InterruptedException {
        RsvpMainPageModel pageModel = new RsvpMainPageModel();
        WebDriver driver = new ChromeDriver();
        driver.get("http://port-80-ylcuoefrob.treehouse-app.com");
        WebElement form = pageModel.find("invitationForm", driver);
        WebElement textField = pageModel.findChildElement("invite_text_field", form);
        WebElement submitBtn = pageModel.findChildElement("submit", form);
        // textField.click();
        textField.sendKeys("Bob");
        submitBtn.click();
        textField.sendKeys("Steve");
        submitBtn.click();
        textField.sendKeys("Carol");
        submitBtn.click();
        List<WebElement> elementList = pageModel.findElements("inviteeList", driver);
        // Edit Steve to Sarah
        WebElement current = null;
        for (int i = 0; i < elementList.size(); i++) {
            current = elementList.get(i);
            WebElement nameElement = pageModel.findChildElement("inviteeName", current);
            String name = nameElement.getText();
            if (name.equals("Steve")) {
                break;
            }
        }
        WebElement editBtn = pageModel.findChildElement("inviteeEditBtn", current);
        editBtn.click();
        Thread.sleep(2000);
        WebElement editName = pageModel.findChildElement("inviteeEditableName", current);
        editName.sendKeys("Sarah");
        WebElement saveBtn = pageModel.findChildElement("inviteeSaveBtn", current);
        saveBtn.click();
    }
}
