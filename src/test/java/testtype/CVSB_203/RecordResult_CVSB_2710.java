package testtype.CVSB_203;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class RecordResult_CVSB_2710 extends BaseTestClass {


    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-203 - AC2 - Fields automatically populated - other test types / current test (no seatbelt installation check)")
    @Test
    public void testFieldsAutomaticallyPopulated() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.pressSave();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("PG9 retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("Yes");
        testTypeDetailsSteps.checkNumberOfSeatbelts("3");
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();

    }
}