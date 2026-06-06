package com.indomaret.klikindomaret.pages;

import com.indomaret.klikindomaret.utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class BasePage {
    public void click(String locatorType, String value) {
        By locator = getLocator(locatorType, value);
        WebDriverWait wait = new WebDriverWait(DriverUtils.appiumDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean isElementVisible(String locatorType, String value) {
        try {
            By locator = getLocator(locatorType, value);
            WebDriverWait wait = new WebDriverWait(DriverUtils.appiumDriver, Duration.ofSeconds(3));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void sendKeys(String locatorType, String value, String text) {
        By locator = getLocator(locatorType, value);
        WebDriverWait wait = new WebDriverWait(DriverUtils.appiumDriver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void typeAndEnter(String locatorType, String value, String text) {
        By locator = getLocator(locatorType, value);
        WebDriverWait wait = new WebDriverWait(DriverUtils.appiumDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

    public String getText(String locatorType, String value) {
        By locator = getLocator(locatorType, value);
        WebDriverWait wait = new WebDriverWait(DriverUtils.appiumDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    private By getLocator(String locatorType, String value) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(value);
            case "xpath":
                return By.xpath(value);
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }
}
