package testtype.CVSB_995;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.EUVehicleCategorySteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleCategoryCountryReg_2677 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-995 - AC5 - Adding EU vehicle category")
    public void addingVehicleCategory() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.checkTitleIsDisplayed();
        euVehicleCategorySteps.checkOptionsAreDisplayed();
    }
}
