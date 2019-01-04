package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AbandonedTestPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Back";
    private static final String REASON_LIST_TITLE_ID = "REASON(S) FOR ABANDONING THIS TEST";
    private static final String LIST_TEXT_ELEMENTS_XPATH = "//XCUIElementTypeStaticText";
    private static final String PAGE_TITLE_ID = "Abandoned test";


    public void clickOnBack() {
        waitUntilPageIsLoaded();
        findElementById(BACK_BUTTON_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    public boolean isReasonsListTitleDisplayed() {
        return findElementById(REASON_LIST_TITLE_ID).isDisplayed();
    }

    public void scrollPageDown() {
        scrollDownTo(500, -800);
    }

    public void scrollPageUp() {
        scrollDownTo(500, 800);
    }

    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(LIST_TEXT_ELEMENTS_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }

        return listOfData;
    }

}
