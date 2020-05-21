package tests;

import constants.NotificationTexts;
import elements.LeavesTable;
import enums.LeaveTableColumn;
import org.junit.jupiter.api.Test;
import pages.AddLeaveModal;
import pages.PersonalLeavesPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuite1 extends BaseTest{


    @Test
    public void checkElementsOnScreen(){
    PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        LeavesTable spreadsheet = new LeavesTable();
        List<String> tableHeaders = spreadsheet.getTableHeaders();
        for (LeaveTableColumn column :LeaveTableColumn.values()) {
            //System.out.println("" +column.getName() + " headeers: " + tableHeaders.toString());
            assertTrue(tableHeaders.contains(column.getName()));
        }


    }

    @Test
    public void checkElementsOnDateModal(){

    }


    @Test
    public void addNewDraftLeave() throws InterruptedException {

        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        int initialRemainingDays = personalLeavesPage.getRemainingDays();

        personalLeavesPage.clickAddButton();

        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal();
        addLeaveModal.clickAddButton();
        System.out.println(personalLeavesPage.getNotifyMessage() + "  ТОВА Е !!!! ");
        //assertEquals( true,NotificationTexts.SUCCESS_ALERT.contains(personalLeavesPage.getNotifyMessage().getAlertText()));
        assertNotEquals( true,NotificationTexts.SUCCESS_ALERT.contains(personalLeavesPage.getNotifyMessage().getAlertText()));
        assertEquals(1, personalLeavesPage.getLeavesTable().getRowsNumber());
        String status = personalLeavesPage.getLeavesTable()
                .getTableCell(LeaveTableColumn.STATUS.getName(), 1).getText();
        assertEquals("Draft", status);


        int newRemainingDays = personalLeavesPage.getRemainingDays();
        assertEquals(initialRemainingDays , newRemainingDays);

    }

}
