package ru.yandex.praktikum.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class StellarBurgersLoginPage {


    //  локатор для ввода в поле "Email"
    @FindBy(how = How.XPATH, using = "//input[@name = 'name']")
    private SelenideElement inputLoginEmail;

    //  локатор для ввода в поле "Password"
    @FindBy(how = How.XPATH, using = "//input[@name = 'Пароль']")
    private SelenideElement inputLoginPassword;

    //  локатор для кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[text() = 'Войти']")
    private SelenideElement buttonLoginEnter;

    //  локатор для ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[text() = 'Зарегистрироваться']")
    private SelenideElement linkRegistration;

    //  локатор для ссылки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[@href='/forgot-password']")
    private SelenideElement linkForgotPassword;

    //  локатор для кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[text()= 'Конструктор']")
    private SelenideElement buttonConstructor;

    //  локатор для логотипа "Stellar_Burgers"
    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;

    //  локатор для заголовка "Вход"
    @FindBy(how = How.XPATH, using = "//h2[text()= 'Вход']")
    private SelenideElement headerLoginForm ;


//   ***********************  методы  для локаторов ******************

    // метод ввода для поля "Email"
    public StellarBurgersLoginPage setLoginEmail (String userEmail) {
        inputLoginEmail.shouldBe(Condition.visible);
        inputLoginEmail.click();
        inputLoginEmail.setValue(userEmail);
        return this;
    }

    // метод ввода для поля "Password"
    public StellarBurgersLoginPage setLoginPassword (String userPassword) {
        inputLoginPassword.shouldBe(Condition.visible);
        inputLoginPassword.click();
        inputLoginPassword.setValue(userPassword);
        return this;
    }

    //  метод клика для кнопки "Войти"
    public StellarBurgersMainPage clickButtonLoginEnter() {
        buttonLoginEnter.shouldBe(Condition.visible);
        buttonLoginEnter.isEnabled();
        buttonLoginEnter.click();
        return page(StellarBurgersMainPage.class);
    }

    // метод для заполнения полей формы регистрации
    public StellarBurgersLoginPage fillLoginForm(String  userEmail, String userPassword) {
        setLoginEmail(userEmail);
        setLoginPassword(userPassword);
        return this;
    }

    //  метод клика для ссылки "Зарегистрироваться"
    public StellarBurgersRegisterPage clickLinkRegistration() {
        linkRegistration.click();
        return page(StellarBurgersRegisterPage.class);
    }

    //  метод клика для ссылки "Восстановить пароль"
    public StellarBurgersForgotPasswordPage clickLinkRepairPassword() {
        linkForgotPassword.click();
        return page(StellarBurgersForgotPasswordPage.class);
    }

    //  Boolean метод для окна подтверждения неуспешной регистрации пользователя (переход на страницу /login)
    public SelenideElement isConfirmThatRegistrationFalls(){
        buttonLoginEnter.shouldNot(Condition.visible);
        return buttonLoginEnter.shouldNot(Condition.visible);
    }

    //  метод для окна подтверждения перехода пользователя на страницу Логина
    public StellarBurgersLoginPage confirmThatLoginWebPageIsDisplayed(){
        headerLoginForm.shouldBe(Condition.visible);
        headerLoginForm.isDisplayed();
        return  this;
     }

    //  метод для окна подтверждения перехода пользователя на страницу Логина
    public Boolean isConfirmThatLoginPageIsDisplayed(){
        headerLoginForm.shouldBe(Condition.visible);
        headerLoginForm.isDisplayed();
        return headerLoginForm.isDisplayed();
    }

}