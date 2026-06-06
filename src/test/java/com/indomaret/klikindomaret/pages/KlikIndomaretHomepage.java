package com.indomaret.klikindomaret.pages;

import com.indomaret.klikindomaret.identifier.HomePage;
import com.indomaret.klikindomaret.identifier.LoginPage;
import com.indomaret.klikindomaret.utils.AppsConstant;

public class KlikIndomaretHomepage extends BasePage{
    public void clickSkipLaunchButton() {
        click(AppsConstant.LOCATOR_TYPE_ID, HomePage.SKIP_BUTTON_LAUNCH_ID);
    }

    public void clickSkipAllPopUpInHomePage() {
        int counter = 5;
        do {
            click(AppsConstant.LOCATOR_TYPE_ID, HomePage.NEXT_BUTTON_INFO_HOMEPAGE);
            counter --;
        } while (isElementVisible(AppsConstant.LOCATOR_TYPE_ID, HomePage.NEXT_BUTTON_INFO_HOMEPAGE)
                && counter > 0);
    }

    public boolean isUserInTheHomePage() {
        return isElementVisible(AppsConstant.LOCATOR_TYPE_ID, HomePage.HOMEPAGE_TAB);
    }

    public void clickAccountMenuBar() {
        click(AppsConstant.LOCATOR_TYPE_ID, HomePage.ACCOUNT_MENU);
    }

    public boolean isUserInAccountPage() {
        return isElementVisible(AppsConstant.LOCATOR_TYPE_ID, LoginPage.LOGIN_BUTTON);
    }
}
