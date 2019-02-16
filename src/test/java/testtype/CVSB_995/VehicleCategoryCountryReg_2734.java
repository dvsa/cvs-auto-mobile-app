package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CountryOfRegisdtrationSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2734 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    CountryOfRegisdtrationSteps countryOfRegisdtrationSteps;

    @Title("CVSB-995 - AC3 - Adding Country of Registration - search field cancel action")
    @Test
    public void addingCountryOfRegistrationAfterListIsFiltered() {
        testTypeCategoryComp.goToTestPage();
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegisdtrationSteps.searchForCountry("Norway");
        countryOfRegisdtrationSteps.cancelSearchAction();
    }
}
