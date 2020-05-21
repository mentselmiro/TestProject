package pages;

import elements.LeavesTable;
import elements.NotificationMessage;
import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;

public class PersonalLeavesPage {

    String ADD_BUTTON_XPATH = "//button[@class='btn btn-primary']";
    String TITLE = "//h2[contains(text(),'Personal leaves')]";
    public static String  TITLE_TEXT = "Personal leaves";
    String REMAINING_DAYS_XPATH = "//div[contains(text(),'Remaining')]/strong";
    String DELETE_BUTTON_XPATH = "//tr[2]//td[6]//button[3]";

    NotificationMessage notifyMessage = new NotificationMessage();


    LeavesTable leavesTable = new LeavesTable();

    public String getTitle() {
        return getDriver().findElement(By.xpath(TITLE)).getText();

    }
    public void clickAddButton(){
        getDriver().findElement(By.xpath(ADD_BUTTON_XPATH)).click();

    }

    public LeavesTable getLeavesTable() {
        return leavesTable;
    }

    public int getRemainingDays() {
        String remainingDays = getDriver().findElement(By.xpath(REMAINING_DAYS_XPATH)).getText();
        return Integer.valueOf(remainingDays);
    }

    public NotificationMessage getNotifyMessage() {
        try {
            notifyMessage.getAlertText();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return notifyMessage;
    }
    public boolean isVisible(){
       return getDriver().findElement(By.xpath(DELETE_BUTTON_XPATH)).isDisplayed();

    }

    public void clickDeleteButton(){
        getDriver().findElement(By.xpath(DELETE_BUTTON_XPATH)).click();
    }
}




