package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.OdometerReadingPage;
import pages.TestPage;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1184 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-695 - AC11 - Save odometer reading - all fields completed")
    @Test
    public void testSaveOdometerAllFieldsCompleted() {
        testTypeCategoryComp.goToTestPage();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("97000");
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.MILES);
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingValue("97,000");
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.MI);

    }

}