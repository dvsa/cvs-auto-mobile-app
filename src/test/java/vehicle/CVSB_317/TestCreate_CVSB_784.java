package vehicle.CVSB_317;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestCreate_CVSB_784 extends BaseTestClass {
    @Steps
    VehicleComp vehicleComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Title("CVSB-317 - AC1 - Create a test")
    @Test()
    public void createATest() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
    }

}
