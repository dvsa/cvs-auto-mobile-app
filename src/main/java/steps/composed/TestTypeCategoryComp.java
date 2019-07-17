package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.*;

public class TestTypeCategoryComp extends ScenarioSteps {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Step
    public void goToTestType(String preparerId, String preparerName) {
        launchSteps.clickGetStarted();
        findAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerId);
        testSteps.addTestType();
    }

    @Step
    public void goToTestPage(String preparerId, String preparerName) {
        preparerComp.goToSelectPreparer();
        preparerSteps.selectAndConfirmPreparerId(preparerId);
    }

    @Step
    public void goToTestPageBySelectingASpecificVehicle(String vin) {
        preparerComp.goToSelectPreparerForASpecificVehicle(vin);
    }

    @Step()
    public void completeAddTestType(String preparerId, String preparerName) {
        goToTestType(preparerId, preparerName);
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
    }

    @Step()
    public void completeAddTestType(String preparerId, String preparerName,String testType) {
        goToTestType(preparerId, preparerName);
        testTypeCategorySteps.selectFromTestTypeList(testType);
    }
}
