package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1027 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-183 - updated by CVSB-3826 - AC1 Search box is presented which asks the VSA for a registration number or VIN number")
    public void testSearchBox() {
        vehicleComp.goToSiteVisit(super.username);
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkSearchBoxAndText("Enter registration number, trailer ID or VIN");
        identifyVehicleSteps.typeInSearchField("1234::?><>+_=oqiwejJKAH");
        identifyVehicleSteps.checkSearchBoxAndText("1234::?><>+_=oqiwejJKAH");
        identifyVehicleSteps.checkSearchBoxIsUnique();
    }
}
