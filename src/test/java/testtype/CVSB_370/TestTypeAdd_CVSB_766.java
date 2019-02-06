package testtype.CVSB_370;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAdd_CVSB_766 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;


    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-370 - AC2 Test types list")
    @Test
    public void testTestTypeList() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.addTestType();
        testTypeCategorySteps.checkInTestTypeList( "class 6a (seatbelt installation check)", "annual test", "retest",
                "prohibition clearence", "technical test", "voluntary test");
        testTypeCategorySteps.checkTestTypePage();

    }

}
