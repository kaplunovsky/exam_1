package PageObject.PageSteps;

import PageObject.PageElem.MainPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class MainSteps extends MainPage {

    @Step("Проверка открытия страницы")
    public static void isOpened() {
        $x(Header).exists();
    }

    @Step("Проверка количества задач в шапке/списке")
    public static void checkValue(){
        int HeadValue = Integer.parseInt(($x(TaskCount).text().split(" "))[0]);
        int ListValue = $$(By.xpath(listTask)).size();
        Assertions.assertEquals(HeadValue, ListValue);
    }

    @Step("Создание задачи. Summary: {SummaryText}")
    public static void CreateTask(String SummaryText, String DescriptionText){

        $x(btnCreate).click();
        sleep(1000);

        $x(fldSummary).click();
        $x(fldSummary).sendKeys(SummaryText);
        $x(lnkAssignToMe).click();
        sleep(2000);
        $x(btnCreateSub).click();
    }

    @Step("Изменения статусов.")
    public static void ChangeStatus(String SummaryText){
        $x(navTasks).click();
        $x(lnkNewSearch).click();
        $x(fldSearchQuery).click();
        $x(fldSearchQuery).setValue(SummaryText);
        $x(fldSearchQuery).sendKeys(Keys.ENTER);
        $x(lnkInProgress).click();
        sleep(1000);
        $x(lnkBProcess).click();
        $x(lnkResolved).click();
    }

    @Step("Проверка статуса {statusvalue}")
    public static void AssertValue(String statusvalue) {
        sleep(1000);
        Assertions.assertEquals($x(assertValue).text(), statusvalue);

    }
}
