package com.indomaret.klikindomaret.pages;

import com.indomaret.klikindomaret.utils.AppsConstant;

public class DetailProductPage extends BasePage {
    public void clickAddToCart() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.DetailProductPage.ADD_TO_CART);
    }

    public void clickCartIcon() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.DetailProductPage.CART_ICON);
    }
}
