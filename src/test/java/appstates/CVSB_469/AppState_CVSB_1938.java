package appstates.CVSB_469;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;
import util.TestHandler;

@RunWith(SerenityRunner.class)
public class AppState_CVSB_1938 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    CommonSteps commonSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Before
    public void goEnable() {
        TestHandler.testTypeEnabledCached().set(true);
    }

    @After
    public void tearDown() {
        TestHandler.testTypeEnabledCached().set(false);
    }

    @Title("CVSB-469 - AC3 Reopen the app after it was closed - redirected to visit timeline screen (ex. app closed by the user, app closed by the device, device turned off)")
    @Test
    public void testAppStateCloseAfterStartVisit() {

        launchSteps.clickGetStarted();
        findAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.startVisit();
        siteVisitSteps.waitUntilPageIsLoaded();
        commonSteps.getPage().closeAndLaunchApp();
        siteVisitSteps.waitUntilPageIsLoaded();

        siteVisitSteps.completeEndVisit();

    }

}
