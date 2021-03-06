package steps;

import io.cucumber.java.BeforeStep;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.IdentifyVehiclePage;
import pages.SearchCriteriaPage;

import data.util.SearchCriteria;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentifyVehicleSteps extends ScenarioSteps {

    IdentifyVehiclePage identifyVehiclePage;

    SearchCriteriaPage searchCriteriaPage;

    @BeforeStep
    public void waitUntilPageIsLoaded(){
        identifyVehiclePage.waitUntilPageIsLoaded();
    }

    @Step
    public void searchForVehicle(String registrationOrVIM) {
        identifyVehiclePage.searchForVehicle(registrationOrVIM);
        identifyVehiclePage.clickSearch();

    }

    @Step
    public void checkIncompleteRecordPopupIsShown() {
        assertThat(identifyVehiclePage.isIncompleteRecordPopupShown()).isTrue();
    }

    @Step
    public void checkIncompleteRecordPopupIsNotShown() {
        assertThat(identifyVehiclePage.isIncompleteRecordPopupShown()).isFalse();
    }

    @Step
    public void setSearchCriteria(String searchOption) {
        identifyVehiclePage.clickSearchCriteriaButton();
        searchCriteriaPage.setSearchCriteriaOption(searchOption);
        searchCriteriaPage.clickSave();
    }

    @Step
    public void typeInSearchField(String registrationOrVIM) {
        identifyVehiclePage.searchForVehicle(registrationOrVIM);
    }

    @Step
    public void clickCancel() {
        identifyVehiclePage.tapCancel();
    }

    @Step
    public void checkSearchBoxAndText(String text) {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyVehiclePage.getSearchFieldText()).contains(text);
    }

    @Step
    public void checkSearchBoxDoesNotContainText(String text) {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyVehiclePage.getSearchFieldText()).doesNotContain(text);
    }

    @Step
    public void pressSearch() {
        identifyVehiclePage.clickSearch();
    }

    @Step
    public void waitUntilPopUpShown() {
        // After clicking on the <Search> button, the Loading message is shown for a while, and then the popup search result.
        identifyVehiclePage.waitForErrorPopUpToDisplay();
    }

    @Step
    public void checkVehicleNotFoundPopUp() {
        identifyVehiclePage.waitForLoadingToEnd();
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isTrue();
    }

    @Step
    public void checkVehicleNotFoundPopUpNotShown() {
        identifyVehiclePage.waitForLoadingToEnd();
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isFalse();
    }

    @Step
    public void pressOkInPopUp() {
        identifyVehiclePage.clickOkInPopUp();
    }

    @Step
    public void checkSearchBoxIsUnique() {
        assertThat(identifyVehiclePage.isSearchFieldUnique()).isTrue();
    }

    @Step
    public void checkSearchBoxIsDisplayed() {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
    }

    @Step
    public void checkLoadingScreen() {
        assertThat(identifyVehiclePage.isLoadingScreenDisplayed()).isTrue();
    }

    @Step
    public void checkVehicleNotFoundPopUpDismissed() {
        assertThat(identifyVehiclePage.isVehicleNotFoundPopUpDisplayed()).isFalse();
    }

    @Step
    public void checkSearchBoxIsEmpty(){
        assertThat(identifyVehiclePage.isSearchFieldEmpty()).isTrue();
    }

    @Step
    public void checkIdentifyVehicleTitleIsDisplayed(){
        assertThat(identifyVehiclePage.isIdentifyVehicleTitleDisplayed()).isTrue();
    }

    @Step
    public void checkSearchCriteriaSectionIsDisplayed() {
        assertThat(identifyVehiclePage.isSearchCriteriaSectionDisplayed()).isTrue();
    }

    @Step
    public void checkSearchCriteriaButtonIsSelected(SearchCriteria searchCriteria) {
        assertThat(identifyVehiclePage.isSearchCriteriaButtonDisplayed(searchCriteria)).isTrue();
    }

    @Step
    public void checkSearchBoxAndText(SearchCriteria searchCriteriaText) {
        assertThat(identifyVehiclePage.isSearchFieldDisplayed()).isTrue();
        assertThat(identifyVehiclePage.getSearchFieldText()).contains("Enter " + searchCriteriaText.getDescription().substring(0, 1).toLowerCase() + searchCriteriaText.getDescription().substring(1));
    }

    @Step
    public void clickSearchCriteriaButton() {
        identifyVehiclePage.pressSearchCriteriaButton();
    }
}

