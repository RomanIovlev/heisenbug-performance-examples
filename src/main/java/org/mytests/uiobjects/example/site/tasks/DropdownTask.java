package org.mytests.uiobjects.example.site.tasks;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@JPage(url = "/performance.html")
public class DropdownTask extends WebPage {
    public String NAME = "PUT HERE YOUR NAME";

    @FindBy(css = "#user-names option")
    private List<WebElement> dropdown;

    public void findValueInDropdown(String name) {
        for (WebElement option : dropdown) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }

    // For Verification
    @FindBy(css = "select[ui=dropdown]")
    private WebElement dropdownValue;
    public String isSelected() {
        return dropdownValue.getText();
    }

}
