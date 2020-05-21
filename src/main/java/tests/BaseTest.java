package tests;

import config.ApplicationConfig;
import config.Credentials;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.DeleteLeaveModal;
import pages.LoginPage;
import pages.PersonalLeavesPage;

import static config.ApplicationConfig.getDriver;
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
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.EMAIL, Credentials.PASSWORD);
        Thread.sleep(300);
        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        assertEquals(PersonalLeavesPage.TITLE_TEXT, personalLeavesPage.getTitle());


    }

    @AfterEach
    public void DeleteItems() throws InterruptedException {

        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        DeleteLeaveModal deleteLeaveModal = new DeleteLeaveModal();
        while (personalLeavesPage.isVisible()) {
            personalLeavesPage.clickDeleteButton();
            Thread.sleep(500);
            deleteLeaveModal.clickYesButton();
            Thread.sleep(500);
        }

    }

    @AfterAll
    public static void theEnd() {
        getDriver().quit();


    }
}