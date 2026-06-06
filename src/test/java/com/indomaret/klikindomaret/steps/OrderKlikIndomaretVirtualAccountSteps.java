package com.indomaret.klikindomaret.steps;

import com.indomaret.klikindomaret.utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderKlikIndomaretVirtualAccountSteps extends ScenarioSteps {
    private AppiumDriver driver;

    public OrderKlikIndomaretVirtualAccountSteps() {
        this.driver = DriverUtils.appiumDriver;
    }

    @Given("User launch klik indomaret app")
    public void userLaunchKlikIndomaretApp() {
        assertTrue(driver != null, "Driver is not initialized!");
        System.out.println("YouTube app is launched successfully.");
    }
}
