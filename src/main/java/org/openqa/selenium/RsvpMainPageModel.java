package org.openqa.selenium;

public class RsvpMainPageModel extends PageModel {
    
    RsvpMainPageModel() {
        super();
        addElement("invitationForm", By.id("registrar"));
        addElement("invite_text_field", By.name("name"));
        addElement("submit", By.name("submit"));
        addElement("inviteeList", By.cssSelector("#invitedList li"));
        addElement("inviteeName", By.cssSelector("span"));
        addElement("inviteeNames", By.cssSelector("ul#invitedList li span"));
        addElement("inviteeEditableName", By.cssSelector("input"));
        addElement("inviteeSaveBtn", By.cssSelector("input + label + button"));
        addElement("inviteeConfirm", By.cssSelector("label input"));
        addElement("inviteeConfirmBtns", By.cssSelector("ul#invitedList li label input"));
        addElement("inviteeEditBtn", By.xpath("./button[1]"));
        addElement("inviteeRemoveBtn", By.cssSelector("button:last-child"));
        addElement("inviteeRemoveBtns", By.cssSelector("ul#invitedList li button:last-child"));
        addElement("hideNonResponders", By.cssSelector("div.main div input"));
    }
}
