package org.mytests.tests.example.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.apache.commons.lang3.time.StopWatch;
import org.mytests.tests.example.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static java.lang.String.format;
import static org.mytests.uiobjects.example.FileUtils.writeInFile;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import org.apache.commons.io.FileUtils;

public class DropdownTest extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        navigation.get(9).click();
    }

    @Test
    public void bigDropdownTest() {
        String name = "Charles Byers";
        StopWatch timer = StopWatch.createStarted();
        dropdownTask.findValueInDropdown(name);
        System.out.println(dropdownTask.NAME + "; Time: " + timer.getTime());
        writeInFile(format("Dropdown Task(%s) Time: %s, ", dropdownTask.NAME, timer.getTime()));
        Assert.assertEquals(dropdownTask.isSelected(), name);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.close();
    }
}
