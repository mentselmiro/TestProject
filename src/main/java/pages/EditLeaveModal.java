package pages;

import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditLeaveModal extends AbstractModal {

    String SAVE_BUTTON_XPATH ="//mat-dialog-container//button[contains(text(), 'Save')]";
    String CANCEL_BUTTON_XPATH = "//mat-dialog-container//button[contains(text(), 'Cancel')]";
    String MODAL_XPATH = "//mat-dialog-container//h2/span[contains(text(), 'Edit')]";

    @Override
    public void verifyCorrectModal() {
        boolean isDisplayed = getDriver().findElement(By.xpath(MODAL_XPATH)).isDisplayed();
        assertTrue(isDisplayed);
    }

    public void clickSaveButton() {
        getDriver().findElement(By.xpath(SAVE_BUTTON_XPATH)).click();

    }

}

