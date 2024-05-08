package testcases.adminpanel.admins;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.actions.SignInPage;

public class Admins extends BaseTest {

    public static Logger log;

    @Epic("Admin Panel")
    @Description("Admin Tests")
    @Test
    public void doLogin() {
        log = LogManager.getLogger(Admins.class);

        SignInPage page = new SignInPage(driver);

        page.doLogin();
    }
}
