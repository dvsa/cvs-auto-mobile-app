package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.PreparerComp;
import steps.composed.TestTypeCategoryComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class Preparer_4886 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB_438 - CVSB-5105 - AC 1 VSA returns to the vehicle details screen")
    public void selectPreparer() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.goBackToVehicleDetailsPage();
        vehicleDetailsSteps.checkPageTitle();
    }
}
