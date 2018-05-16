package org.mytests.uiobjects.example.site.tasks;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import com.epam.jdi.tools.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@JPage(url = "/performance.html")
public class TableTask extends WebPage {
    public String NAME = "PUT HERE YOUR NAME";

    @FindBy(id = "users-table") WebElement table;

    public String getUserName(String name, String email) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() == 4 && columns.get(0).getText().contains(name) &&
                columns.get(2).getText().contains(email))
                return row.getText();
        }
        return "";
    }
}
