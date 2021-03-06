package sitevisit.CVSB_179;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSelectReasonSteps;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore("test was ignored because functionality for wait time was suppressed in the app")
@RunWith(SerenityRunner.class)
public class TimeNotTesting_CVSB_4524 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    SiteVisitSelectReasonSteps selectReasonSteps;

    @Title("CVSB-179 - AC1 - Remains inactive for more than 5 minutes")
    @Test
    public void test5minInactivity() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        siteVisitComp.goToSiteVisit(super.username);
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.waitUntilTimeNotTesting();
        siteVisitSteps.checkTimeNotTesting();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.pressSave();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkTimeNotTestingPopUp();
        siteVisitSteps.pressOkInTimeNotTestingPopUp();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.checkSelectionForEachReason();
        selectReasonSteps.pressSave();
        selectReasonSteps.checkPopUp();
        selectReasonSteps.pressOkInPopUp();
        selectReasonSteps.typeNote("I fell asleep ...");
        selectReasonSteps.pressSave();
        siteVisitSteps.checkAddedReasons("I fell asleep ...");
    }
}
