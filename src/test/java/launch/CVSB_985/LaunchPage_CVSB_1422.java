package launch.CVSB_985;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LaunchSteps;
import steps.FindAnATFSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class LaunchPage_CVSB_1422 extends BaseTestClass {

        @Steps
        LaunchSteps launchSteps;

        @Steps
        FindAnATFSteps findAnATFSteps;

        @Title("CVSB-985 - AC1 - VSA is taken to the first screen of the app")
        @Test
        public void testAtfListAlphabeticallyOrdered() {
            launchSteps.clickGetStarted();
            findAnATFSteps.checkATFSearchButtonAndList(atfService.getUniqueIdentifier(0),atfService.getUniqueIdentifier(1), atfService.getFirstLetter(0));
            findAnATFSteps.checkListIsAlphabeticallyOrdered();
        }
}
