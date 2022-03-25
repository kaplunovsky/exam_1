package steps;

import PageObject.PageSteps.AutorizationSteps;
import PageObject.PageSteps.MainSteps;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AutorizationSteps.*;
import static PageObject.PageSteps.MainSteps.*;
import static hooks.GetConfig.getConfigurationValue;

public class ts_Jira {
    @Test
    @Tag("")
    @DisplayName("Проверка количества задач")
    public void Test1() {
        openPage(getConfigurationValue("AutorizationURL"));
        clicButtonLogIn(getConfigurationValue("login"));
        clicButtonPassword(getConfigurationValue("password"));
        clicButtonIn();

        Selenide.open(getConfigurationValue("MainURL"), MainSteps.class);
        isOpened();
        checkValue();
    }

    @Test
    @Tag("")
    @DisplayName("Создание задачи. Изменение статусов.")
    public void Test2() {
        openPage(getConfigurationValue("AutorizationURL"));
        clicButtonLogIn(getConfigurationValue("login"));
        clicButtonPassword(getConfigurationValue("password"));
        clicButtonIn();

        openPage(getConfigurationValue("AutorizationURL"));
        isOpened();
        CreateTask(getConfigurationValue("SummaryText"), getConfigurationValue("DescriptionText"));
        ChangeStatus(getConfigurationValue("SummaryText"));
        AssertValue(getConfigurationValue("AssertTaskStatus"));
    }
}
