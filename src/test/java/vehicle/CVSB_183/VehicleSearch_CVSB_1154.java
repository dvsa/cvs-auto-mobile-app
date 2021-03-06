package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1154 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-183 - AC2 Search for vehicle using last six-digits of the VIN number")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testSearchUsingSixDigitVIN() {
        vehicleComp.goToSiteVisit(super.username);
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("678410");
        identifyVehicleSteps.checkSearchBoxAndText("678410");
        identifyVehicleSteps.pressSearch();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");

    }
}
