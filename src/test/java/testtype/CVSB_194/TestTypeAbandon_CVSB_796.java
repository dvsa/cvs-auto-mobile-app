package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import steps.*;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_796 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    AbandonTestComp abandonTestComp;

    @Steps
    AbandonedTestSteps abandonedTestSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;


    @Title("CVSB-194 - AC1 Add additional comments")
    @Test
    public void testAddAdditionalComments() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkCommentSection();
        abandonTestSteps.addAdditionalComments("Additional comment test123");
        abandonTestSteps.checkAddedComment("Additional comment test123");
    }

}
