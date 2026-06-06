package com.indomaret.klikindomaret.steps;

import com.indomaret.klikindomaret.pages.KlikIndomaretHomepage;
import com.indomaret.klikindomaret.pages.LoginPage;
import com.indomaret.klikindomaret.utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderKlikIndomaretVirtualAccountSteps extends ScenarioSteps {
    private static final Logger log = LoggerFactory.getLogger(OrderKlikIndomaretVirtualAccountSteps.class);
    private AppiumDriver driver;
    private KlikIndomaretHomepage klikIndomaretHomepage = new KlikIndomaretHomepage();
    private LoginPage loginPage = new LoginPage();

    public OrderKlikIndomaretVirtualAccountSteps() {
        this.driver = DriverUtils.appiumDriver;
    }

    @Given("User launch klik indomaret app")
    public void userLaunchKlikIndomaretApp() {
        assertTrue(driver != null, "Driver is not initialized!");
        System.out.println("YouTube app is launched successfully.");
    }

    @When("User click skip button in initial launch")
    public void userClickSkipButtonInInitialLaunch() {
        log.info("Click skip launch button");
        klikIndomaretHomepage.clickSkipLaunchButton();
    }

    @And("User click all pop up in homepage")
    public void userClickAllPopUpInHomepage() {
        log.info("Click all pop up button");
        klikIndomaretHomepage.clickSkipAllPopUpInHomePage();
    }

    @Then("User already in homepage")
    public void userAlreadyInHomepage() {
        assertTrue(klikIndomaretHomepage.isUserInTheHomePage(), "User is not in the homepage!");
    }



    @When("User click account menubar")
    public void userClickAccountMenubar() {
        klikIndomaretHomepage.clickAccountMenuBar();
        assertTrue(klikIndomaretHomepage.isUserInAccountPage(), "User is not in account page!");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("User input the phoneNumber {string}")
    public void userInputThePhoneNumber(String phoneNumber) {
        loginPage.inputPhoneNumber(phoneNumber);
    }

    @And("User click next")
    public void userClickNext() {
        loginPage.clickNext();
    }

    @And("User input the password {string}")
    public void userInputThePassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("User click login")
    public void userClickLogin() {
        loginPage.clickLogin();
    }

    @And("User click maybe later button")
    public void userClickMaybeLaterButton() {
        loginPage.clickMaybeLaterButton();
    }
}
