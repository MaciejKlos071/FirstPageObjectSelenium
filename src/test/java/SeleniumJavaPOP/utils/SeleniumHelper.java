package SeleniumJavaPOP.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumHelper {


    // --------------- Dodatkowe metody pomocnicze ----------------------- //
    protected void waitForElementVisible(WebDriver driver, WebElement elementToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }

    protected void clickElement(WebDriver driver, WebElement elementToClick) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();

    }

    public static void wairForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void wairForElementToVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected static void waitForNotEmptyList(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(browser -> browser.findElements(locator).size() > 0);
    }

    protected static void waitForNotEmptyList(WebDriver driver, List<WebElement> webElementsList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(browser -> webElementsList.size() > 0);
    }

    public static Media getScreenshot(WebDriver driver) throws IOException {
        String path = takeScreenShot(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    private static String takeScreenShot(WebDriver driver) throws IOException {
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/TestScreebShot" + randomNumber + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

    protected List<String> informationList(WebDriver driver, List<WebElement> errorsList) {
        SeleniumHelper.waitForNotEmptyList(driver, errorsList);
        List<String> errors = errorsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return errors;
    }

}
