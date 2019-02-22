package defect.CVSB_139;

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
public class DefectAdd_CVSB_670 extends BaseTestClass {

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
    AdvisoryDetailsSteps advisoryDetailsSteps;


    @Title("CVSB-139 - AC3 - Add advisory defect screen")
    @Test
    public void addAdvisoryDefectScreen() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("7. Engine MIL");
        defectDescriptionSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.waitUntilPageIsLoaded();
    }
}
