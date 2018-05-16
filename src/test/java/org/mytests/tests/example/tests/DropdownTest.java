package org.mytests.tests.example.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.apache.commons.lang3.time.StopWatch;
import org.mytests.tests.example.SimpleTestsInit;
import org.mytests.uiobjects.example.FileUtils;
import org.mytests.uiobjects.example.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mytests.uiobjects.example.FileUtils.COUNT;
import static org.mytests.uiobjects.example.FileUtils.process;
import static org.mytests.uiobjects.example.FileUtils.writeInFile;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;

public class DropdownTest extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        navigation.get(9).click();
    }

    @Test(invocationCount = COUNT)
    public void bigDropdownTest() {
        String name = "Charles Byers";
        process(() -> dropdownTask.findValueInDropdown(name),
            dropdownTask.NAME, "Dropdown Task");
        Assert.assertEquals(dropdownTask.isSelected(), name);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.close();
    }
    @AfterClass
    public void afterClass() {
        writeInFile(dropdownTask.NAME, "Dropdown Task");
    }
}
