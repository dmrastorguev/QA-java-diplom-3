package ru.yandex.praktikum.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class StellarBurgersForgotPasswordPage {

    //  локатор для ввода в поле "Email" на странице восстановления пароля
    @FindBy(how = How.XPATH, using = "//input[@name = 'name']")
    private SelenideElement inputLoginEmail;

    //  локатор для кнопки "Восстановить" на странице восстановления пароля
    @FindBy(how = How.XPATH, using = "//button[text() = 'Восстановить']")
    private SelenideElement buttonToResetPasswordForm;

    //  локатор для ссылки "Вспомнили пароль? Войти" на странице восстановления пароля
    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private SelenideElement linkToLoginForm;

    //   ***********************  методы  для локаторов ******************

    // метод клика для ссылки "Вспомнили пароль? Войти"
    public StellarBurgersLoginPage clickLinkToLoginForm() {
        linkToLoginForm.click();
        return page(StellarBurgersLoginPage.class);
    }


}
