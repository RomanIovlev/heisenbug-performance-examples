package org.mytests.tests.example.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import org.apache.commons.lang3.time.StopWatch;
import org.mytests.tests.example.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.mytests.uiobjects.example.FileUtils.writeInFile;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;

public class TableTest extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        navigation.get(9).click();
    }

    @Test
    public void hugeTableTest() {
        StopWatch timer = StopWatch.createStarted();
        String row = tableTask.getUserName("Meyer", "co.uk");
        System.out.println(tableTask.NAME + "; Time: " + timer.getTime());
        writeInFile(format("Dropdown Task(%s) Time: %s, ", tableTask.NAME, timer.getTime()));
        Assert.assertEquals(row, "Brian Meyer (016977) 0358 mollis.nec@seddictumeleifend.co.uk Houston");
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.close();
    }
}
