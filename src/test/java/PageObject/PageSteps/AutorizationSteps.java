package PageObject.PageSteps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static PageObject.PageElem.AutorizationPage.*;
import static com.codeborne.selenide.Selenide.$x;

public class AutorizationSteps {

    @Step("Открытие страницы {url}")
    public static void openPage(String url){
        Selenide.open(url, AutorizationSteps.class);
    }


    @Step("Авторизация пользователем. Ввод логина: {login}")
    public  static void clicButtonLogIn(String login) {
        $x(fldLogin).click();
        $x(fldLogin).sendKeys(login);
    }
    @Step("Авторизация пользователем. Ввод пароля. ")
    public  static void  clicButtonPassword(String password) {
        $x(fldPassword).click();
        $x(fldPassword).sendKeys(password);
    }

    @Step("Нажатие кнопки. ")
    public  static void  clicButtonIn() {
        $x(btnLogIn).click();
    }
}
