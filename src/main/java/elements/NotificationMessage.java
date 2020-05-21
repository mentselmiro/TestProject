package elements;

import org.openqa.selenium.By;

import static config.ApplicationConfig.getDriver;

public class NotificationMessage {

    String SUCCESS_ALERT_XPATH = "//div[@class='alert alert-success']";
    String EDIT_ALERT_XPATH = "//div[@class='alert alert-success']";





    public String getAlertText() throws InterruptedException {
        Thread.sleep(1000);
        String bomb = getDriver().findElement(By.xpath(SUCCESS_ALERT_XPATH)).getText();
        System.out.println(bomb + "  <= HONOLULULU");
        return getDriver().findElement(By.xpath(SUCCESS_ALERT_XPATH)).getText();
    }

}
