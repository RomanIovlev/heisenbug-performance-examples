package org.mytests.tests.example.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
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

public class TextfieldTest extends SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        navigation.get(9).click();
    }

    @Test(invocationCount = COUNT)
    public void longTextTest() {
        String text = "Lorem ipsum dolor sit amet, eos numquam rationibus ad. Ius cu accumsan salutatus, ne pro purto ridens vulputate. Cu eum doctus tritani, munere sanctus complectitur vis id. Paulo vulputate te eos, suas tollit laudem nam id. His esse rebum reprimique ut, te solum atqui homero vim.\n\n" +
            "Labitur salutatus eos an. Vim ut dicam fuisset. Ex sed animal accommodare, utinam graeci iisque vim id, ea fugit scripta deleniti nec. Eos cu nisl veri meis. Affert audiam copiosae mel ne, fabulas menandri temporibus has et. Sed latine graecis ei, eu fugit soluta intellegam vis, nibh graeci meliore ad duo.\n\n" +
            "Et quis meis delenit mea, ius ea sumo laboramus vituperatoribus. Te simul luptatum tractatos nam, eam in causae constituam, quod stet ancillae nam ei. Ne his dico veniam legere, id has vidisse euismod sanctus. Vis putant volumus tincidunt et.\n\n" +
            "Has eirmod consequat ad. Sea illud clita ut, has quando accusata cotidieque an, volutpat iudicabit definitionem ut sea. Pri at atqui molestiae, nibh ullum consulatu vix at. Nec id nisl nonumes epicurei, et vitae possit probatus ius. Fierent delicata argumentum ut quo. Tation tincidunt sed eu, sit in nostrud democritum.\n\n" +
            "Usu esse utroque sapientem ad. Eam ut consul soleat sapientem, cu dolor consequuntur vis. Erat temporibus mea id, has ex dicam tritani. Pertinacia expetendis consectetuer eos ei, vidit malis periculis est ea, ne nam movet fuisset. Pro id habemus definitiones, in ferri solum reprehendunt mei. Vel eligendi honestatis liberavisse id.";
        String text2 = text + "\n" + text;
        process(() -> textfieldTask.enterTextInField(text2),
                textfieldTask.NAME, "Textfield Task");
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.close();
    }
    @AfterClass
    public void afterClass() {
        writeInFile(textfieldTask.NAME, "Textfield Task");
    }
}
