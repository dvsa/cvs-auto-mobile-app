package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2064 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Title("CVSB-169 - AC5 - VSA ends the visit from the site visit timeline")
    @Test
    public void testEndVisit() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        siteVisitComp.goToSiteVisit(super.username);
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkEndVisitPopUp();
        siteVisitSteps.clickOkInEndVisitPopUp();

    }
}
