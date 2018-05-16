package org.mytests.tests.example.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import org.apache.commons.lang3.time.StopWatch;
import org.mytests.tests.example.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.mytests.uiobjects.example.FileUtils.COUNT;
import static org.mytests.uiobjects.example.FileUtils.process;
import static org.mytests.uiobjects.example.FileUtils.writeInFile;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;

public class TableTest extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        navigation.get(9).click();
    }

    @Test(invocationCount = COUNT)
    public void hugeTableTest() {
        String row = process(() -> tableTask.getUserName("Meyer", "co.uk"),
                tableTask.NAME, "Table Task");
        Assert.assertEquals(row, "Brian Meyer (016977) 0358 mollis.nec@seddictumeleifend.co.uk Houston");
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.close();
    }
    @AfterClass
    public void afterClass() {
        writeInFile(tableTask.NAME, "Table Task");
    }
}
