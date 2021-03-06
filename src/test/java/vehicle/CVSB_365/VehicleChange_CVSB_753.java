package vehicle.CVSB_365;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleChange_CVSB_753 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;


    @Title("CVSB-365 - AC1 - Change a vehicle before confirming vehicle details")
    @Test
    public void testChangeBeforeConfirmVehicleDetails() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.pressBackButton();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.waitUntilPageIsLoaded();
    }


}
