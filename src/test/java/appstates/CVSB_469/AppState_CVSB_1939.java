package appstates.CVSB_469;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AppState_CVSB_1939  extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    CommonSteps commonSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;



    @Title( "CVSB-469 - AC4 Reopen the app after it was closed - redirected to test screen (ex. app closed by the user, app closed by the device, device turned off)")
    @Test
    public void testAppStateCloseAtTestPage() {

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
        testSteps.waitUntilPageIsLoaded();
        commonSteps.getPage().closeAndLaunchApp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");


    }

}