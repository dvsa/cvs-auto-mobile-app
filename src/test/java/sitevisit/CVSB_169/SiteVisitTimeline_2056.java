package sitevisit.CVSB_169;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class SiteVisitTimeline_2056 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-169 - AC1 - VSA is presented with the Site Visit timeline after completing an ATF site check")
    public void testSiteVisitTimeline() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        siteVisitComp.goToSiteVisit(super.username);
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.checkEndVisitButton();

    }
}
