package PageObject.PageSteps;

import PageObject.PageElem.MainPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import static PageObject.PageElem.MainPage.*;
import static com.codeborne.selenide.Selenide.*;

public class MainSteps {

    public static void isOpened() {
        $x(Header).exists();
    }

    @Step("Проверка количества задач d шапке/списке {HeadValue}/{ListValue}")
    public static void checkValue(){
        int HeadValue = Integer.parseInt($(TaskCount).text().split(" ")[0]);
        Dimension ListValue = $x(listTask).getSize();

        System.out.println("Кол-во в шапке/списке:  " + HeadValue + " / " + ListValue);

        Assert.assertEquals(HeadValue, ListValue);
    }

    @Step("Создание задачи. Summary: {SummaryText}")
    public static void CreateTask(String SummaryText, String DescriptionText){

        $x(btnCreate).click();
        sleep(1000);
        $x(fldSummary).click();
        $x(fldSummary).sendKeys(SummaryText);
        //      fldDesc.click();       // element not interactable
        //      fldDesc.sendKeys(DescText);  // element not interactable
        $x(lnkAssignToMe).click();
        $(btnCreateSub).click();
    }

    @Step("Изменения статусов.")
    public static void ChangeStatus(String SummaryText){
        $(navTasks).click();
        $(lnkNewSearch).click();
        $(fldSearchQuery).click();
        $(fldSearchQuery).setValue(SummaryText);
        $(fldSearchQuery).sendKeys(Keys.ENTER);
        $(lnkInProgress).click();
        sleep(1000);
        $(lnkBProcess).click();
        $(lnkResolved).click();
    }

    @Step("Проверка статуса {statusvalue}")
    public static void AssertValue(String statusvalue) {
        sleep(1000);
        Assertions.assertEquals($(assertValue).text(), statusvalue);
        System.out.println("Статус: " + $(assertValue).text());
    }
}