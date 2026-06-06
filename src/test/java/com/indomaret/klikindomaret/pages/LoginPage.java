package com.indomaret.klikindomaret.pages;

import com.indomaret.klikindomaret.utils.AppsConstant;

public class LoginPage extends BasePage{
    public void clickLoginButton() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.LoginPage.LOGIN_BUTTON);
    }

    public void inputPhoneNumber(String phoneNumber) {
        sendKeys(AppsConstant.LOCATOR_TYPE_XPATH,
                com.indomaret.klikindomaret.identifier.LoginPage.PHONE_NUMBER, phoneNumber);
    }

    public void clickNext() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.LoginPage.NEXT_BUTTON);
    }

    public void inputPassword(String password) {
        sendKeys(AppsConstant.LOCATOR_TYPE_XPATH,
                com.indomaret.klikindomaret.identifier.LoginPage.PASSWORD, password);
    }

    public void clickLogin() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.LoginPage.LOGIN_BUTTON_NEXT);
    }

    public void clickMaybeLaterButton() {
        click(AppsConstant.LOCATOR_TYPE_ID, com.indomaret.klikindomaret.identifier.LoginPage.MAYBE_LATER);
        if(isElementVisible(AppsConstant.LOCATOR_TYPE_XPATH,
                com.indomaret.klikindomaret.identifier.LoginPage.NOT_NOW_PASSWORD_SAVE)) {
            click(AppsConstant.LOCATOR_TYPE_XPATH,
                    com.indomaret.klikindomaret.identifier.LoginPage.NOT_NOW_PASSWORD_SAVE);
        }
    }
}
