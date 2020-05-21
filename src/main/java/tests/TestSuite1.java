package tests;

import elements.LeavesTable;
import enums.LeaveTableColumn;
import org.junit.jupiter.api.Test;
import pages.AddLeaveModal;
import pages.PersonalLeavesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuite1 extends BaseTest{

    @Test
    public void checkElementsOnScreen(){
    PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        LeavesTable spreadsheet = new LeavesTable();


    }

    @Test
    public void checkElementsOnDateModal(){

    }


    @Test
    public void addNewDraftLeave(){

        PersonalLeavesPage personalLeavesPage = new PersonalLeavesPage();
        int initialRemainingDays = personalLeavesPage.getRemainingDays();

        personalLeavesPage.clickAddButton();

        AddLeaveModal addLeaveModal = new AddLeaveModal();
        addLeaveModal.verifyCorrectModal();
        addLeaveModal.clickAddButton();
        assertEquals(1, personalLeavesPage.getLeavesTable().getRowsNumber());
        String status = personalLeavesPage.getLeavesTable()
                .getTableCell(LeaveTableColumn.STATUS.getName(), 1).getText();
        assertEquals("Draft", status);


        int newRemainingDays = personalLeavesPage.getRemainingDays();
        assertEquals(initialRemainingDays , newRemainingDays);

    }
}
