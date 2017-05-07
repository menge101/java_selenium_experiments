package org.openqa.selenium;

public class RsvpMainPageModel extends PageModel {
    
    RsvpMainPageModel() {
        super();
        addElement("invitationForm", By.id("registrar"));
        addElement("invite_text_field", By.name("name"));
        addElement("submit", By.name("submit"));
        addElement("inviteeList", By.cssSelector("#invitedList li"));
        addElement("hideNonResponders", By.cssSelector("div.main div input"));
    }
}
