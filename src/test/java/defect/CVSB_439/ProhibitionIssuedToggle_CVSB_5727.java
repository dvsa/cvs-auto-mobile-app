package defect.CVSB_439;

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
public class ProhibitionIssuedToggle_CVSB_5727 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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

    @Title("CVSB-439 - AC3 - VSA proceeds with a dangerous not marked with an asterisk defect w/o issuing a prohibition")
    @Test
    public void testProhibitionNotEnabledPopUpNoAsteriskDefect() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("7. Size and Type of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("7.1 (a) (ii) DANGEROUS");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.checkProhibitionIssuedSwitchOff();
        defectDetailsSteps.tapDone();
        defectDetailsSteps.checkProhibitionPopUpNoAsteriskDefect();

    }
}
