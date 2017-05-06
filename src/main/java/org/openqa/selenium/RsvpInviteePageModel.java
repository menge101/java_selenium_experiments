package org.openqa.selenium;

public class RsvpInviteePageModel extends PageModel {
    
    RsvpInviteePageModel() {
        super();
        addElement("name", By.cssSelector("span"));
        addElement("confirmed", By.cssSelector("label input"));
        addElement("edit", By.xpath("./button[1]"));
        addElement("remove", By.cssSelector("button:last-child"));
        addElement("editableName", By.cssSelector("input"));
        addElement("save", By.cssSelector("input + label + button"));
    }
}
