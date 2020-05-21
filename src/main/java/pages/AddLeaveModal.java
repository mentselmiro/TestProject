package pages;

import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddLeaveModal extends AbstractModal {

    String ADD_BUTTON_XPATH ="//mat-dialog-container//button[contains(text(), 'Add')]";
    String CANCEL_BUTTON_XPATH = "//mat-dialog-container//button[contains(text(), 'Cancel')]";
    String MODAL_XPATH = "//mat-dialog-container//h2/span[contains(text(), 'Add')]";
    String FROM_FIELD_ID ="fromDate";
    String TO_FIELD_ID = "toDate";
    String DAYS_XPATH = "//div[contains(text(),'Days:')]";
    String DAYS_OFF_XPATH = "//div[contains(text(),'Days off:')]";
    String FROM_CALENDAR = "//div[@class='col'][1]//button[@class='mat-icon-button']";
    String TO_CALENDAR = "//div[@class='col'][2]//button[@class='mat-icon-button']";

    @Override
    public void verifyCorrectModal() {
       boolean isDisplayed = getDriver().findElement(By.xpath(MODAL_XPATH)).isDisplayed();
       assertTrue(isDisplayed);
    }

    public void clickAddButton() {
        getDriver().findElement(By.xpath(ADD_BUTTON_XPATH)).click();

    }

}

