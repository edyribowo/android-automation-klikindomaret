package com.indomaret.klikindomaret.steps;

import com.indomaret.klikindomaret.pages.CartPage;
import com.indomaret.klikindomaret.pages.DetailProductPage;
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
    private DetailProductPage detailProductPage = new DetailProductPage();
    private CartPage cartPage = new CartPage();

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
        klikIndomaretHomepage.clickCloseAdv();
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

    @When("User click homepage banner")
    public void userClickHomepageBanner() {
        klikIndomaretHomepage.clickHomepagaBanner();
    }

    @When("User click search in homepage")
    public void userClickSearchInHomepage() {
        klikIndomaretHomepage.clickSearchBar();
    }

    @And("User search {string}")
    public void userSearch(String searchValue) {
        klikIndomaretHomepage.userSearchProduct(searchValue);
    }

    @And("User click detail product {string}")
    public void userClickDetailProduct(String searchValue) {
        klikIndomaretHomepage.userClickDetailProduct(searchValue);
    }

    @And("User click add to cart in detail product page")
    public void userClickAddToCartInDetailProductPage() {
        detailProductPage.clickAddToCart();
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        detailProductPage.clickCartIcon();
        assertTrue(cartPage.isUserInCartPage(), "User is not in cart page!");
    }

    @When("User click shipping type")
    public void userClickShippingType() {
        cartPage.clickShippingType();
    }

    @Then("User select shipping type {string}")
    public void userSelectShippingType(String shippingType) {
        cartPage.clickShippingTypeOption(shippingType);
    }

    @And("User select time {string}")
    public void userSelectTime(String slot) {
        cartPage.clickShippingSelectSlot(slot);
    }

    @And("User click confirm")
    public void userClickConfirm() {
        cartPage.clickConfirmButton();
    }

    @When("User click check promo coupon")
    public void userClickCheckPromoCoupon() {
        cartPage.clickCheckPromoOrCoupon();
    }

    @When("User click belanja xtra menu")
    public void userClickBelanjaXtraMenu() {
        cartPage.clickBelanjaXtra();
    }

    @And("User click banner shipping xtra")
    public void userClickBannerShippingXtra() {
        cartPage.clickBannerShippingXtra();
    }

    @When("User expand the detail product")
    public void userExpandTheDetailProduct() {
        cartPage.expandTotalPayment();
    }

    private int parseCurrency(String amount) {
        if (amount == null || amount.isEmpty() || amount.equals("0")) return 0;
        String digits = amount.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) return 0;
        return Integer.parseInt(digits);
    }

    @Then("Verify the total payment is correct")
    public void verifyTheTotalPaymentIsCorrect() {
        String productPriceStr = cartPage.getProductPrice();
        String shippingFeeStr = cartPage.getShippingFee();
        String insuranceFeeStr = cartPage.getIssuranceFee();
        String totalPaymentStr = cartPage.getTotalPayment();

        int productPrice = parseCurrency(productPriceStr);
        int shippingFee = parseCurrency(shippingFeeStr);
        int insuranceFee = parseCurrency(insuranceFeeStr);
        int totalPayment = parseCurrency(totalPaymentStr);

        int expectedTotal = productPrice + shippingFee + insuranceFee;

        log.info("Payment Breakdown -> Product Price: {}, Shipping Fee: {}, Insurance: {} | Expected Total: {}, Actual Total UI: {}",
                productPrice, shippingFee, insuranceFee, expectedTotal, totalPayment);

        assertTrue(totalPayment == expectedTotal,
                "Total payment (" + totalPayment + ") does not match sum of product, shipping, and insurance (" + expectedTotal + ")");
    }


    @And("User close the payment detail")
    public void userCloseThePaymentDetail() {
        cartPage.clickClosePaymentDetail();
    }

    @When("User click Buy button")
    public void userClickBuyButton() {
        cartPage.clickBuyButton();
        cartPage.skipPromo();
    }

    @Then("User select virtual account as payment")
    public void userSelectVirtualAccountAsPayment() {
        cartPage.selectVirtualAccountPaymentBCA();
    }

    @And("User click Pay Now")
    public void userClickPayNow() {
        cartPage.clickPayNow();
    }
}
