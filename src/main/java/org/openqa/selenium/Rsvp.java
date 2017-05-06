package org.openqa.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class Rsvp {
    private RsvpMainPageModel mainModel;
    private RsvpInviteePageModel inviteeModel;
    private WebDriver driver;

    public Rsvp(String url, WebDriver webDriver) {
        mainModel = new RsvpMainPageModel();
        inviteeModel = new RsvpInviteePageModel();
        driver = webDriver;
        driver.get(url);
    }

    public void addInvitee(String name) {
        WebElement form = mainModel.find("invitationForm", driver);
        WebElement textField = mainModel.findChildElement("invite_text_field", form);
        WebElement submitBtn = mainModel.findChildElement("submit", form);
        textField.sendKeys(name);
        submitBtn.click();
    }

    public void editName(String original, String desired) {
        WebElement current = findParentByName(original);
        WebElement editBtn = mainModel.findChildElement("inviteeEditBtn", current);
        editBtn.click();
        WebElement editName = mainModel.findChildElement("inviteeEditableName", current);
        editName.clear();
        editName.sendKeys(desired);
        WebElement saveBtn = mainModel.findChildElement("inviteeSaveBtn", current);
        saveBtn.click();
    }

    public void removeInvitee(String name) {
        WebElement current = findParentByName(name);
        WebElement removeBtn = mainModel.findChildElement("inviteeRemoveBtn", current);
        removeBtn.click();
    }

    public void toggleHideNonResponders() {
        WebElement checkbox = mainModel.find("hideNonResponders", driver);
        checkbox.click();
    }

    public void setNonResponders() {
        WebElement checkbox = mainModel.find("hideNonResponders", driver);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void unSetNonResponders() {
        WebElement checkbox = mainModel.find("hideNonResponders", driver);
        System.out.println("Checked attribute: " + checkbox.getAttribute("checked"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void printNonResponderState() {
        WebElement checkbox = mainModel.find("hideNonResponders", driver);
        System.out.println(Boolean.toString(checkbox.isSelected()));
    }

    private WebElement findParentByName(String name) {
        List<WebElement> elementList = mainModel.findElements("inviteeList", driver);
        WebElement current = null;
        for (int i = 0; i < elementList.size(); i++) {
            current = elementList.get(i);
            WebElement nameElement = mainModel.findChildElement("inviteeName", current);
            String elementName = nameElement.getText();
            if (elementName.equals(name)) {
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) throws InterruptedException {
        Rsvp rsvp = new Rsvp("http://port-80-ylcuoefrob.treehouse-app.com", new ChromeDriver());

        // Invite some people
        rsvp.addInvitee("Bob");
        rsvp.addInvitee("Steve");
        rsvp.addInvitee("Carol");

        // Edit Steve to Sarah
        rsvp.editName("Steve", "Sarah");

        // Remove Bob
        rsvp.removeInvitee("Bob");

        // set show responders
        rsvp.printNonResponderState();
        rsvp.setNonResponders();
        rsvp.printNonResponderState();
        rsvp.unSetNonResponders();
        rsvp.printNonResponderState();
        rsvp.toggleHideNonResponders();
        rsvp.printNonResponderState();
    }
}
