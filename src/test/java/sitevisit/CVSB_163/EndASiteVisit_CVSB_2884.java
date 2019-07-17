package sitevisit.CVSB_163;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.FindAnATFSteps;
import steps.SiteVisitSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EndASiteVisit_CVSB_2884 extends BaseTestClass {

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Title("CVSB-163 - AC1 - Start visit")
    @Test
    public void testStartVisit() {
        launchSteps.clickGetStarted();
        findAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.checkEndVisitButton();

    }
}
