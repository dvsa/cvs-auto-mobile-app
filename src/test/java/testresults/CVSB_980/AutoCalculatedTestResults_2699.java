package testresults.CVSB_980;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculatedTestResults_2699 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Title("CVSB_980 - AC1 - Abandon criteria")
    @WithTag("Smoke_2")
    @Test
    public void abandonCriteria() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("5");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.scrollDown();
        testReviewSteps.changeTestDetails();
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testReviewSteps.checkTestStatus("Annual test", "ABANDONED");
    }
}
