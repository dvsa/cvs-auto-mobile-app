package testtype.CVSB_370;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeAdd_CVSB_765 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-370 - AC1 'Add a test type' option")
    public void testTestTypeOption() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkAddATestTypeButtonVisibility();

    }

}
