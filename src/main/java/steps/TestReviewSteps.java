package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitPage;
import pages.TestReviewPage;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestReviewSteps extends ScenarioSteps {

    TestReviewPage testReviewPage;

    @Step
    public void checkPageTitleIsDisplayed(){
        testReviewPage.waitUntilPageIsLoaded();
        assertThat(testReviewPage.checkPageTitleIsDisplayed()).isTrue();
    }

    @Step
    public void checkElementIsDisplayed(String element){
        assertThat(testReviewPage.checkDisplayedElement(element)).isTrue();
    }

    @Step
    public void goToPreviousVehicle(){
        testReviewPage.goToPreviousVehicle();
    }

    @Step
    public void checkElementIsNotDisplayed(String element){
        assertThat(testReviewPage.checkDisplayedElement(element)).isFalse();
    }

    @Step
    public void changeDetails() {
        testReviewPage.clickChangeDetailsButton();
    }

    @Step
    public void changeVehicleDetails() {
        testReviewPage.clickChangeVehicleDetailsButton();
    }

    @Step
    public void changeTestDetails() {
        testReviewPage.clickChangeTestDetailsButton();
    }

    @Step
    public void saveChangedDetails() {
        testReviewPage.clickSaveChangedDetailsButton();
    }

    @Step
    public void checkElementIsNotEditable(String element) {
        assertThat(testReviewPage.checkEditableElement(element)).isFalse();
    }

    @Step
    public void checkDateIsDisplayed() {
        LocalDateTime localDateTime = LocalDateTime.now() ;
        Integer dayOfSystem = localDateTime.getDayOfMonth() + 1;
        int monthOfSystem = localDateTime.getMonthValue();
        Integer yearOfSystem = localDateTime.getYear() - 1;

        String day = dayOfSystem.toString();
        String month = new DateFormatSymbols().getMonths()[monthOfSystem].substring(0, 3);
        String year = yearOfSystem.toString();

        String date = day + " " + month + " " + year;
        assertThat(testReviewPage.checkDisplayedElement(date)).isTrue();
    }

    @Step
    public void changeDetailsIsNotDisplayed() {
        assertThat(testReviewPage.isChangeDetailsButtonDisplayed()).isFalse();
    }

    @Step
    public void changeDetailsIsDisplayed() {
        assertThat(testReviewPage.isChangeDetailsButtonDisplayed()).isTrue();
    }

    @Step
    public void goToTestPage() {
        testReviewPage.goToTestPage();
    }

    @Step
    public void checkTestStatus(String testType, String status) {
        waitForPageToLoad();
        assertThat(testReviewPage.verifyTestStatus(testType,status)).isTrue();
    }

    @Step
    public void checkCertificateNumberIs(String expectedCertificateNumber) {
        assertThat(testReviewPage.checkDisplayedElement(expectedCertificateNumber));
    }

    @Step
    public void checkNotesAre(String expectedNotes) {
        assertThat(testReviewPage.checkDisplayedElement(expectedNotes));
    }

    @Step
    public void scrollDown() {
        testReviewPage.scrollPageDown();
        // testReviewPage.waitUntilPageIsLoaded();
    }

    @Step
    public void pressSubmit() {
        testReviewPage.clickSubmitButton();
    }

    @Step
    public void pressSubmitInPopUp() {
        //siteVisitPage.setSubmitTestTime();
        testReviewPage.clickSubmitInPopUp();
    }

    @Step
    public void waitForPageToLoad() {
        testReviewPage.waitUntilPageIsLoaded();
    }

    @Step
    public void scrollUp() {
        testReviewPage.scrollPageUp();
    }

    @Step
    public void checkSubmitPopUp() {
        assertThat(testReviewPage.checkPopUpIsDisplayed()).isTrue();
    }

    @Step
    public void pressCancelInPopUp() {
        testReviewPage.clickCancelInPopUp();
    }

    @Step
    public void checkLoadingIndicator() {
        assertThat(testReviewPage.isLoadingIndicatorDisplayed()).isTrue();
    }

    @Step
    public void checkSubmitErrorPopUp() {
        assertThat(testReviewPage.isErrorPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressSettings() {
        testReviewPage.clickSettings();
    }

    @Step
    public void checkDeviceSettings() {
        assertThat(testReviewPage.isDeviceSettingsPageDisplayed()).isTrue();
    }

    @Step
    public void pressTryAgain() {
        testReviewPage.clickTryAgain();
    }

    @Step
    public void checkLoadingIndicatorIsNotDisplayed() {
        assertThat(testReviewPage.isLoadingIndicatorNotDisplayed()).isTrue();
    }

    @Step
    public void pressNextVehicle() {
        testReviewPage.clickNextVehicle();
    }

    @Step
    public void pressSubmitTests() {
        testReviewPage.clickSubmitTestsButton();
    }

    @Step
    public void checkElementValue(String element, String value){
        testReviewPage.waitUntilPageIsLoaded();
        testReviewPage.checkElementValue(element,value);
    }

    @Step
    public void verifyOnlyOneChangeDetailsIsDisplayed() {
        testReviewPage.checkOnlyOneChangeDetailsIsDisplayed();
    }
}
