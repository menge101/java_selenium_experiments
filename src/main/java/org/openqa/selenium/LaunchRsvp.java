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
    private RsvpMainPageModel model;
    private WebDriver driver;

    public LaunchRsvp(String url) {
        model = new RsvpMainPageModel();
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void addInvitee(String name) {
        WebElement form = model.find("invitationForm", driver);
        WebElement textField = model.findChildElement("invite_text_field", form);
        WebElement submitBtn = model.findChildElement("submit", form);
        textField.sendKeys("Bob");
        submitBtn.click();
    }

    public void editName(String original, String desired) {
        List<WebElement> elementList = model.findElements("inviteeList", driver);
        WebElement current = null;
        for (int i = 0; i < elementList.size(); i++) {
            current = elementList.get(i);
            WebElement nameElement = model.findChildElement("inviteeName", current);
            String name = nameElement.getText();
            if (name.equals(original)) {
                break;
            }
        }
        WebElement editBtn = model.findChildElement("inviteeEditBtn", current);
        editBtn.click();
        WebElement editName = model.findChildElement("inviteeEditableName", current);
        editName.clear();
        editName.sendKeys(desired);
        WebElement saveBtn = model.findChildElement("inviteeSaveBtn", current);
        saveBtn.click();
    }

    public static void main(String[] args) throws InterruptedException {
        LaunchRsvp rsvp = new LaunchRsvp("http://port-80-ylcuoefrob.treehouse-app.com");

        // Invite some people
        rsvp.addInvitee("Bob");
        rsvp.addInvitee("Steve");
        rsvp.addInvitee("Carol");

        // Edit Steve to Sarah
        rsvp.editName("Steve", "Sarah");
    }
}
