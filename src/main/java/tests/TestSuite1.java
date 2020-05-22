package tests;

import constants.NotificationTexts;
import constants.TeamLeavesText;
import elements.LeavesTable;
import enums.LeaveTableColumn;
import org.junit.jupiter.api.Test;
import pages.AddLeaveModal;
import pages.PersonalLeavesPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite1 extends BaseTest{


    @Test
    public void checkElementsOnScreen(){
    PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        LeavesTable spreadsheet = new LeavesTable();
        List<String> tableHeaders = spreadsheet.getTableHeaders();
        for (LeaveTableColumn column :LeaveTableColumn.values()) {
            assertTrue(tableHeaders.contains(column.getName()));
        }

        LeavesTable teamText = new LeavesTable();
        assertEquals(true,personalLeavesPage.getTeamLeavesText().contains(TeamLeavesText.TEAM_LEAVES_TEXT));
        assertTrue(personalLeavesPage.isAddButtonDisplayed());
    }

    @Test
    public void checkElementsOnDateModal() throws InterruptedException {
        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        personalLeavesPage.clickAddButton();
        Thread.sleep(1000);
        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal();
        assertTrue(addLeaveModal.isAddButtonVisible());
        assertTrue(addLeaveModal.isCancelButtonVisible());
        assertTrue(addLeaveModal.isToFieldVisible());
        assertTrue(addLeaveModal.isFromFieldVisible());
        assertTrue(addLeaveModal.isToCalendarVisible());
        assertTrue(addLeaveModal.isFromCalendarVisible());
        assertTrue(addLeaveModal.isDaysVisible());
        assertTrue(addLeaveModal.isDateOffVisible());
        addLeaveModal.clickCancelButton();
    }


    @Test
    public void addNewDraftLeave() throws InterruptedException {

        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        int initialRemainingDays = personalLeavesPage.getRemainingDays();//This takes the remaining days value

        personalLeavesPage.clickAddButton();
        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal(); //validates the Add modal
        addLeaveModal.clickAddButton();

        assertEquals( true,personalLeavesPage
                .getNotifyMessage().getAlertText().contains(NotificationTexts.SUCCESS_ALERT));

        assertEquals(1, personalLeavesPage.getLeavesTable().getRowsNumber());
        String status = personalLeavesPage.getLeavesTable()
                .getTableCell(LeaveTableColumn.STATUS.getName(), 1).getText();
        assertEquals("Draft", status);


        int newRemainingDays = personalLeavesPage.getRemainingDays(); //This counts the days next to "Remaining: "
        assertEquals(initialRemainingDays , newRemainingDays);

    }

}
