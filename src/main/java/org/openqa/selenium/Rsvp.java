package org.openqa.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Rsvp {
    private RsvpMainPageModel model;
    private WebDriver driver;

    public Rsvp(String url) {
        model = new RsvpMainPageModel();
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void addInvitee(String name) {
        WebElement form = model.find("invitationForm", driver);
        WebElement textField = model.findChildElement("invite_text_field", form);
        WebElement submitBtn = model.findChildElement("submit", form);
        textField.sendKeys(name);
        submitBtn.click();
    }

    public void editName(String original, String desired) {
        WebElement current = findParentByName(original);
        WebElement editBtn = model.findChildElement("inviteeEditBtn", current);
        editBtn.click();
        WebElement editName = model.findChildElement("inviteeEditableName", current);
        editName.clear();
        editName.sendKeys(desired);
        WebElement saveBtn = model.findChildElement("inviteeSaveBtn", current);
        saveBtn.click();
    }

    public void removeInvitee(String name) {
        WebElement current = findParentByName(name);
        WebElement removeBtn = model.findChildElement("inviteeRemoveBtn", current);
        removeBtn.click();
    }

    private WebElement findParentByName(String name) {
        List<WebElement> elementList = model.findElements("inviteeList", driver);
        WebElement current = null;
        for (int i = 0; i < elementList.size(); i++) {
            current = elementList.get(i);
            WebElement nameElement = model.findChildElement("inviteeName", current);
            String elementName = nameElement.getText();
            if (elementName.equals(name)) {
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) throws InterruptedException {
        Rsvp rsvp = new Rsvp("http://port-80-ylcuoefrob.treehouse-app.com");

        // Invite some people
        rsvp.addInvitee("Bob");
        rsvp.addInvitee("Steve");
        rsvp.addInvitee("Carol");

        // Edit Steve to Sarah
        rsvp.editName("Steve", "Sarah");

        // Remove Bob
        rsvp.removeInvitee("Bob");
    }
}
