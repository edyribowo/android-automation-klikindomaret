package com.indomaret.klikindomaret.pages;

import com.indomaret.klikindomaret.identifier.CartPageIdentifier;
import com.indomaret.klikindomaret.utils.AppsConstant;

public class CartPage extends BasePage {
    public boolean isUserInCartPage() {
        return isElementVisible(AppsConstant.LOCATOR_TYPE_XPATH, CartPageIdentifier.CART_TITLE_HEADER);
    }

    public void clickShippingType() {
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_XPATH, CartPageIdentifier.CLOSE_POP_UP))
            click(AppsConstant.LOCATOR_TYPE_XPATH, CartPageIdentifier.CLOSE_POP_UP);

        if(isElementVisible(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.CLOSE_POP_UP_BOX))
            click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.CLOSE_POP_UP_BOX);

        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.SHIPPING_TYPE_MENU);
    }

    public void clickShippingTypeOption(String shippingType) {
        String xpath = "//android.widget.TextView[@resource-id=\"com.indomaret.klikindomaret:id/ffp\" " +
                "and @text='"+shippingType+"']";
        click(AppsConstant.LOCATOR_TYPE_XPATH, xpath);
    }

    public void clickShippingSelectSlot(String slot) {
        String xpath = "//android.widget.TextView[@resource-id=\"com.indomaret.klikindomaret:id/ala\" and @text='" + slot +"']";
        click(AppsConstant.LOCATOR_TYPE_XPATH, xpath);
    }

    public void clickConfirmButton() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.CONFIRM_SLOT_BUTTON);
    }

    public void clickCheckPromoOrCoupon() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.CHECK_PROMO_OR_COUPON);
    }

    public void clickBelanjaXtra() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.BELANJA_XTRA_MENU);
    }

    public void clickBannerShippingXtra() {
        click(AppsConstant.LOCATOR_TYPE_XPATH, CartPageIdentifier.BANNER_SHIPPING_XTRA);
    }

    public void expandTotalPayment() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.DETAIL_PAYMENT_EXPAND);
    }

    public String getProductPrice() {
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.PRODUCT_PRICE)) {
            return getText(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.PRODUCT_PRICE);
        } else return "0";
    }

    public String getShippingFee() {
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.SHIPPING_FEE)) {
            return getText(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.SHIPPING_FEE);
        } else return "0";
    }

    public String getIssuranceFee() {
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.INSURANCE_FEE)) {
            return getText(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.INSURANCE_FEE);
        } else return "0";
    }

    public String getTotalPayment() {
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.TOTAL_PAYMENT)) {
            return getText(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.TOTAL_PAYMENT);
        } else return "0";
    }

    public void clickClosePaymentDetail() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.CLOSE_PAYMENT_BUTTON);
    }

    public void clickBuyButton() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.BUY_BUTTON);
    }

    public void selectVirtualAccountPaymentBCA() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.BRIVA);
    }

    public void clickPayNow() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.PAY_NOW_BUTTON);
    }

    public void skipPromo() {
        click(AppsConstant.LOCATOR_TYPE_ID, CartPageIdentifier.SKIP_PROMO);
    }
}
