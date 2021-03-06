package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectReasonSteps extends ScenarioSteps {
    SelectReasonPage selectReasonPage;

    @Step
    public void checkSelectReasonPage() {
        selectReasonPage.waitUntilPageIsLoaded();
        if (!selectReasonPage.isTextTipDisplayed())
            selectReasonPage.scrollPageUp();
        assertThat(selectReasonPage.isPageTitleDisplayed() && selectReasonPage.isTextTipDisplayed()).isTrue();
    }

    @Step
    public void pressBackButton() {
        selectReasonPage.clickOnBackButton();
    }

    @Step
    public void checkListIsScrollableByFirstReason() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> listOfExpectedReasonTexts = selectReasonPage.getListOfReasonTexts();
        String firstReasonText = listOfExpectedReasonTexts.get(0);
        assertThat(selectReasonPage.isElementFromListDisplayed(firstReasonText)).isTrue();
        int oldYPosition = selectReasonPage.getYPositionForElement(firstReasonText);
        selectReasonPage.scrollPageDown();
        assertThat(selectReasonPage.isElementFromListDisplayed(firstReasonText)).isFalse();
        int newYPosition = selectReasonPage.getYPositionForElement(firstReasonText);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void checkReasonsList() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> actualDataList = selectReasonPage.findAllReasonsByXpath();
        List<String> expectedDataList = selectReasonPage.getListOfReasonTexts();
        for (String expectedData : expectedDataList) {
            assertThat(actualDataList).contains(expectedData);

        }
    }

    @Step
    public void checkReasonsTirList() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> actualDataList = selectReasonPage.findAllReasonsByXpath();
        List<String> expectedDataList = selectReasonPage.getListOfReasonTirTexts();
        for (String expectedData : expectedDataList) {
            assertThat(actualDataList).contains(expectedData);

        }
    }

    @Step
    public void checkSpecialistReasonsList() {
        selectReasonPage.waitUntilPageIsLoaded();
        List<String> actualDataList = selectReasonPage.findAllReasonsByXpath();
        List<String> expectedDataList = selectReasonPage.getListOfSpecialistReasonTexts();
        for (String expectedData : expectedDataList) {
            assertThat(actualDataList).contains(expectedData);
        }
    }

    @Step
    public void checkOneOrMoreReasonsAreSelectable() {
        assertThat(selectReasonPage.isNextButtonDisplayed()).isFalse();
        selectReasonPage.selectReason(SelectReasonPage.Reasons.REASON_1);
        assertThat(selectReasonPage.isReasonSelected(1)).isTrue();
        assertThat(selectReasonPage.isNextButtonDisplayed()).isTrue();
        selectReasonPage.scrollPageDown();
        selectReasonPage.selectReason(SelectReasonPage.Reasons.REASON_8);
        assertThat(selectReasonPage.isReasonSelected(8)).isTrue();
        assertThat(selectReasonPage.isNextButtonDisplayed()).isTrue();
        selectReasonPage.scrollPageUp();
        selectReasonPage.selectReason(SelectReasonPage.Reasons.REASON_3);
        assertThat(selectReasonPage.isReasonSelected(3)).isTrue();
        assertThat(selectReasonPage.isNextButtonDisplayed()).isTrue();
    }


    /**
     * Step that selects any reason. If the reason is not displayed, the page is scrolled.
     * @param reason
     */
    @Step
    public void selectAReason(SelectReasonPage.Reasons reason) {
        waitForPageToLoad();
        if (selectReasonPage.isReasonFromListDisplayed(reason)){
            selectReasonPage.selectReason(reason);
        } else {
            selectReasonPage.scrollPageDown();
            if (selectReasonPage.isReasonFromListDisplayed(reason)) {
                selectReasonPage.selectReason(reason);
            } else {
                selectReasonPage.scrollPageUp();
                selectReasonPage.selectReason(reason);
            }
        }
    }

    @Step
    public void selectTheReason(SelectReasonPage.ReasonsTir reason) {
        if (selectReasonPage.isReasonFromListDisplayed(reason)){
            selectReasonPage.selectReason(reason);
        } else {
            selectReasonPage.scrollPageDown();
            if (selectReasonPage.isReasonFromListDisplayed(reason)) {
                selectReasonPage.selectReason(reason);
            } else {
                selectReasonPage.scrollPageUp();
                selectReasonPage.selectReason(reason);
            }
        }
    }

    @Step
    /**
     * Step that selects any reason. If the reason is not displayed, the page is scrolled.
     * @param reason
     */
    public void selectAReason(SelectReasonPage.ReasonsSpecialist reason) {
        waitForPageToLoad();
        if (selectReasonPage.isSpecialistReasonFromListDisplayed(reason)){
            selectReasonPage.selectSpecialistReason(reason);
        } else {
            selectReasonPage.scrollPageDown();
            if (selectReasonPage.isSpecialistReasonFromListDisplayed(reason)) {
                selectReasonPage.selectSpecialistReason(reason);
            } else {
                selectReasonPage.scrollPageUp();
                selectReasonPage.selectSpecialistReason(reason);
            }
        }
    }

    @Step
    public void selectASpecialistReason(SelectReasonPage.ReasonsSpecialist reason) {
        if (selectReasonPage.isSpecialistReasonFromListDisplayed(reason)){
            selectReasonPage.selectSpecialistReason(reason);
        } else {
            selectReasonPage.scrollPageDown();
            if (selectReasonPage.isSpecialistReasonFromListDisplayed(reason)) {
                selectReasonPage.selectSpecialistReason(reason);
            } else {
                selectReasonPage.scrollPageUp();
                selectReasonPage.selectSpecialistReason(reason);
            }
        }
    }

    @Step
    public void pressNextButton() {
        assertThat(selectReasonPage.isNextButtonDisplayed()).isTrue();
        selectReasonPage.clickOnNextButton();
    }

    @Step
    public void selectMultipleReasons(SelectReasonPage.Reasons... reasons) {
        for (SelectReasonPage.Reasons reason : reasons) {
            selectAReason(reason);
        }
    }

    @Step
    public void checkReasonsAreDisplayed(SelectReasonPage.Reasons... reasons) {
        selectReasonPage.areAllReasonsDisplayed(reasons);
    }

    @Step
    public void checkReasonsAreDisplayed(SelectReasonPage.ReasonsSpecialist... reasons) {
        assertThat(selectReasonPage.areAllReasonsDisplayed(reasons)).isTrue();
    }

    @Step
    public void waitForPageToLoad() {
        selectReasonPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkReasonIsDisplayed(String reason) {
        assertThat(selectReasonPage.isElementFromListDisplayed(reason)).isTrue();
    }

    @Step
    public void selectTheReason(String reason) {
        selectReasonPage.selectReason(reason);
    }

    @Step
    public void checkReasonIsDisplayed(SelectReasonPage.ReasonsTir reason) {
        assertThat(selectReasonPage.isReasonFromListDisplayed(reason)).isTrue();
    }

    @Step
    public String getReasonTexts(SelectReasonPage.ReasonsTir reason) {
        return selectReasonPage.getReasonTexts(reason);
    }

    @Step
    public String getReasonTexts(SelectReasonPage.Reasons reason) {
        return selectReasonPage.getReasonTexts(reason);
    }
}

