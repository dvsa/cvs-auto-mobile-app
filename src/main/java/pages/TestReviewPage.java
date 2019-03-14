package pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TestReviewPage extends BasePage {
    private final String BACK_TO_TEST_ID = "arrow back Test";
    private final String TEST_REVIEW_TITLE_ID = "Test review";
    private final String CHANGE_DETAILS_BUTTON_ID = "Change details";
    private final String SAVE_CHANGED_DETAILS = "Save";
    private final String ABANDON_TEST_TYPE = "Abandon test type";
    private final String REMOVE_TEST_TYPE = "Remove test type";
    private static final String TEST_BUTTON_ID = "arrow back Test";

    public void goToTestPage() {
        findElementById(TEST_BUTTON_ID).click();
    }

    public void clickGoToTestOverviewScreen() {
        findElementById(BACK_TO_TEST_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_REVIEW_TITLE_ID);
    }

    public boolean checkPageTitleIsDisplayed() {
        return findElementById(TEST_REVIEW_TITLE_ID).isDisplayed();
    }

    public boolean checkDisplayedElement(String element) {
        return findElementByXpath("//*[@name=\"" + element + "\"]").isDisplayed();
    }

    public void clickChangeDetailsButton() {
        findElementById(CHANGE_DETAILS_BUTTON_ID).click();
    }

    public boolean isChangeDetailsButtonDisplayed() {
        boolean status;
        try {
            status = findElementById(CHANGE_DETAILS_BUTTON_ID).isDisplayed();
        } catch (Exception e) {
            status = false;
        }

        return status;
    }

    public void clickSaveChangedDetailsButton() {
        findElementById(SAVE_CHANGED_DETAILS).click();
    }

    public boolean checkEditableElement(String element) {
        WebElement we = findElementByXpath("//*[@name=\"" + element + "\"]");
        try {
            we.sendKeys("Test");
            return true;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public void pressTestTypeAbandonButton() {
        findElementById(ABANDON_TEST_TYPE).click();
    }

    public void pressTestTypeRemoveButton() {
        findElementById(REMOVE_TEST_TYPE).click();
    }

    public boolean verifyTestStatus(String testType, String status) {
        boolean isTestTypeDisplayed = checkDisplayedElement(testType);
        boolean isStatusDisplayed = checkDisplayedElement(status);

        if (isStatusDisplayed && isTestTypeDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    public void scrollPageDown() {
        scrollDownTo(500, -200);
    }
}
