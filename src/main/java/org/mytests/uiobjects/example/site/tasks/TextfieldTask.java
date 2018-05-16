package org.mytests.uiobjects.example.site.tasks;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@JPage(url = "/performance.html")
public class TextfieldTask extends WebPage {
    public String NAME = "PUT HERE YOUR NAME";

    @FindBy(css = "#textarea-performance")
    WebElement textfield;

    public void enterTextInField(String text) {
        textfield.sendKeys(text);
    }
}
