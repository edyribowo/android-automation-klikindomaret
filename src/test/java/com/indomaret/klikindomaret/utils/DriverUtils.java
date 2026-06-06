package com.indomaret.klikindomaret.utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {
    public static AppiumDriver appiumDriver;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", org.example.utils.ConfigReader.get("platformName"));
        desiredCapabilities.setCapability("appium:deviceName", org.example.utils.ConfigReader.get("deviceName"));
        desiredCapabilities.setCapability("appium:automationName", org.example.utils.ConfigReader.get("automationName"));
        desiredCapabilities.setCapability("appium:appPackage", org.example.utils.ConfigReader.get("appPackage"));
        desiredCapabilities.setCapability("appium:appActivity", org.example.utils.ConfigReader.get("appActivity"));

        String noReset = org.example.utils.ConfigReader.get("noReset");
        if (noReset != null) {
            desiredCapabilities.setCapability("appium:noReset", Boolean.parseBoolean(noReset));
        }

        appiumDriver = new AppiumDriver(new URL(org.example.utils.ConfigReader.get("appiumURL")), desiredCapabilities);
    }

    @AfterAll
    public static void tearDown() {
        if(appiumDriver!=null)
            appiumDriver.quit();
    }
}
