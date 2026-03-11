package com.automation.tests;

import org.testng.annotations.Test;
import com.automation.base.Basetest;
import com.automation.pages.LoginPage;

public class LoginTest extends Basetest {

    @Test(groups = {"regression"})
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver, wait);
        login.login("Kavita77@gmail.com", "Rest@123");
    }
}
