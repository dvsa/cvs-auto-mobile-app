package defect.CVSB_439;

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
public class ProhibitionIssuedToggle_CVSB_4962 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;


    @Title("CVSB-439 - AC1 - VSA confirms a prohibition have been issued against a dangerous defect (Retest)")
    @Test
    public void testProhibitionIssuedRetest() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testSteps.selectTestType("Retest", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Paid retest");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("2. Anchorages");
        defectDescriptionSteps.selectDefect("3.2 (a) (ii) * DANGEROUS");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.setProhibisionIssued();
        defectDetailsSteps.checkProhibitionIssuedSwitchOn();
    }

}