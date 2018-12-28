package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BasePage extends PageObject {


    protected WebElement findElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected WebElement waitUntilPageIsLoadedById(String id) {
        return waitUntiPageIsLoadedByElement(By.id(id));
    }

    protected WebElement waitUntilPageIsLoadedByXpath(String xPath) {
        return waitUntiPageIsLoadedByElement(By.xpath(xPath));
    }

    protected void waitUntillNumberOfElementsToBe(By locator, int elementNumber) {
        FluentWait wait = globalFluentWait();
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, elementNumber));
    }

    protected void scrollDownTo(int xOffset, int yOffset) {
        new TouchAction(((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .press(PointOption.point(500,596))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point(xOffset,yOffset))
                .release()
                .perform();
    }

    protected void tap(WebElement webElement) {
        new TouchAction(((IOSDriver)((WebDriverFacade) getDriver()).getProxiedDriver()))
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement)))
                .perform();
    }

    protected List<WebElement> findAllDataByComposedXpath(String... data) {
        List<String> xpathList = new ArrayList<>();

        for (String value : data) {
            String currentXpathElement = "//*[contains(@name,'" + value + "')] | //*[contains(@label, '" + value + "')] | //*[contains(@value,'" + value + "')] ";
            xpathList.add(currentXpathElement);
        }

        String xpathToSearch = xpathList.stream().collect(Collectors.joining(" | "));

        return findElementsByXpath(xpathToSearch);

    }

    public int getXPositionForElement(String element) {
        return findElementByXpath("//*[@name='" + element + "']").getLocation().getX();
    }

    public int getYPositionForElement(String element) {
        return findElementByXpath("//*[@name='" + element + "']").getLocation().getY();
    }


    private WebElement waitUntiPageIsLoadedByElement(By locator) {


        FluentWait wait = globalFluentWait();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));


        return getDriver().findElement(locator);

    }


    private FluentWait globalFluentWait() {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        return wait;
    }


}
