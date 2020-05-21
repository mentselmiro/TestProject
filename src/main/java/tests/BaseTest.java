package tests;

import config.ApplicationConfig;
import config.Credentials;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;
import pages.PersonalLeavesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {


    @BeforeAll
    public static void beforeClass() {
        ApplicationConfig.invokeBrowser();

        try {
            login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void login() throws InterruptedException {
        LoginPage loginPage  = new LoginPage();
        loginPage.login(Credentials.EMAIL,Credentials.PASSWORD);
        Thread.sleep(300);
        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        assertEquals(PersonalLeavesPage.TITLE_TEXT, personalLeavesPage.getTitle());
    }

    @AfterAll
    public static void theEnd() {
        ApplicationConfig.getDriver().quit();

    }
}
