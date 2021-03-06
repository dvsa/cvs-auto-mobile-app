package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdrDetailsPage extends BasePage {

    private static final String ADR_DETAILS_PAGE_TITLE = "ADR details";
    private static final String PAGE_ALL_TEXT_XPATH = "XCUIElementTypeStaticText";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ADR_DETAILS_PAGE_TITLE);
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    /**
     * Creates a list of the vehicle summary values using xpath
     *
     * @return the list of data containing both Keys and Values of the details page
     */
    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("value"));
        }

        return listOfData;
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if (findElementById(ADR_DETAILS_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isRegistrationPlateDisplayed(String registrationPlate) {
        boolean status = false;
        if (findElementById(registrationPlate).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean elementIsDisplayed(String elementName) {
        for(WebElement element : getAllElements()){
            if(element.getAttribute("name").equals(elementName)){
                return true;
            }
        }
        return false;
    }

    public boolean isFieldValueNull(String value) {
        boolean status = false;
        if (findElementByXpath("//*[@value='" + value + "']").getAttribute("value") == null) {
            status = true;
        }
        return status;
    }

    public boolean isAttribute(String attribute, String value) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_XPATH);
        List<String> actualData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            actualData.add(webElement.getAttribute("name"));
        }
//        logger.info("list: " + actualData);
        for(String data:actualData){
//            logger.info("inside for @: " + data);
            if(data.equals(attribute)){
//                logger.info("comparing data: " + data + " with: " + value);
                if(actualData.get(actualData.indexOf(data)+1).equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<WebElement> getAllElements(){
        return findElementsByClassName(PAGE_ALL_TEXT_XPATH);
    }

    public boolean elementIsDisplayedAfter(String adrDetail, String adrSection) {
        List<WebElement> webElementList = getAllElements();
        WebElement sectionElement = null;
        WebElement detailElement = null;
        for(WebElement webElement : webElementList){

            if(webElement.getAttribute("name").equals(adrSection)){

                sectionElement = webElement;
            }
            if(webElement.getAttribute("name").equals(adrDetail)){

                if (webElement.isDisplayed()) {
                    // Just in case the element is present on screen but hidden.
                    detailElement = webElement;
                }
            }
        }
        return (webElementList.indexOf(sectionElement) < webElementList.indexOf(detailElement));
    }

    public boolean elementIsDisplayedRightAfter(String detail, String value) {
        List<WebElement> webElementList = getAllElements();
        for(int i = 0 ; i < webElementList.size()-1 ; i++){
            if(webElementList.get(i).getAttribute("name").equals(detail) && webElementList.get(i+1).getAttribute("name").equals(value)){
                return true;
            }
        }
        return false;
    }

    public boolean isPageTitleDisplayed(String pageTitle) {
        return pageTitle.equals(ADR_DETAILS_PAGE_TITLE);
    }
}
