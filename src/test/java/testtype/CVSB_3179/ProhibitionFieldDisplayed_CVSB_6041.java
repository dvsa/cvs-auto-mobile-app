package testtype.CVSB_3179;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ProhibitionFieldDisplayed_CVSB_6041 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Title("CVSB-3179 - TCD - Prohibition field is displayed for dangerous defect (Retest)")
    @Test
    public void prohibitionFieldNotDisplayedAtADefectLevelDangerousDefectRetest() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Paid retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Class 6A retest (seatbelt installation check)");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (b) DANGEROUS");
        defectDetailsSteps.checkIssuedInMobileComplianceIsPresent();
        defectDetailsSteps.checkProhibitionLabelIsDisplayed();
        defectDetailsSteps.tapDone();
    }
}
