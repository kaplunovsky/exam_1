package steps;

import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AutorizationSteps.*;
import static PageObject.PageSteps.MainSteps.*;
import static com.codeborne.selenide.Selenide.sleep;
import static hooks.GetConfig.getConfigurationValue;

public class JiraTest extends WebHooks {

    @Test
    @Tag("Jira_Test_1")
    @DisplayName("Проверка количества задач")
    public void Test1() {
        openPage(getConfigurationValue("AutorizationURL"));
        clicButtonLogIn(getConfigurationValue("login"));
        clicButtonPassword(getConfigurationValue("password"));
        clicButtonIn();

        openPage(getConfigurationValue("MainURL"));
        isOpened();
        sleep(1000);
        checkValue();
    }

    @Test
    @Tag("Jira_Test_2")
    @DisplayName("Создание задачи. Изменение статусов.")
    public void Test2() {
        openPage(getConfigurationValue("AutorizationURL"));
        clicButtonLogIn(getConfigurationValue("login"));
        clicButtonPassword(getConfigurationValue("password"));
        clicButtonIn();

        openPage(getConfigurationValue("AutorizationURL"));
        isOpened();
        CreateTask(getConfigurationValue("SummaryText" )+ "2", getConfigurationValue("DescriptionText"));
        ChangeStatus(getConfigurationValue("SummaryText"));
        AssertValue("ГОТОВО");
    }

}
