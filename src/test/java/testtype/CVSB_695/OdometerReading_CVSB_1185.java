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
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1185 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-695 - AC10/11 - Edit odometer reading after saving")
    @Test
    public void testEditAfterSaving() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("97000");
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.MILES);
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.MI);
        testSteps.checkOdometerReadingValueFormatted("97,000");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("1089872");
        odometerReadingSteps.pressEditUnit();
        odometerReadingSteps.selectUnitOption(OdometerReadingPage.UnitOptions.KILOMETRES);
        odometerReadingSteps.pressSave();
        testSteps.checkOdometerReadingButton(TestPage.OdometerUnitIndicatives.KM);
        testSteps.checkOdometerReadingValueFormatted("1,089,872");
    }
}
