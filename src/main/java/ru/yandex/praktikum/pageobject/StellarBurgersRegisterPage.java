package ru.yandex.praktikum.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.praktikum.utils.UserGeneration;

import static com.codeborne.selenide.Selenide.page;


public class StellarBurgersRegisterPage {

    //  локатор для ввода в поле "Имя" на странице регистрации
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following::input[1]")
    private SelenideElement inputUserName;

    //  локатор для ввода в поле "Email" на странице регистрации
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following::input[1]")
    private SelenideElement inputUserEmail;

    //  локатор для ввода в поле "Password" на странице регистрации
    @FindBy(how = How.XPATH, using = "//input[@name = 'Пароль']")
    private SelenideElement inputUserPassword;

    //  локатор для кнопки "Зарегистрироваться" на странице регистрации
    @FindBy(how = How.XPATH, using = "//button[text() = 'Зарегистрироваться']")
    private SelenideElement buttonUserRegistration;

    //  локатор для ссылки "Уже зарегистрированы? Войти" на странице регистрации
    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private SelenideElement linkToLoginForm;

    //  локатор для проверки пароля на корректность на странице регистрации
    @FindBy(how = How.XPATH, using = "//div[@class = 'input__icon input__icon-action']")
    private SelenideElement checkPassword;

    //  локатор для сообщения об ошибке "Некорректный пароль" на странице регистрации
    @FindBy(how = How.XPATH, using = "//p[@class = 'input__error text_type_main-default']")
    private SelenideElement errorPasswordMessage;


    //      ***********************  методы  для локаторов ******************

    // метод ввода для поля "Имя"
    public StellarBurgersRegisterPage setUserName (String userName) {
        inputUserName.shouldBe(Condition.enabled);
        inputUserName.click();
        inputUserName.setValue(userName);
        return this;
    }

    // метод ввода для поля "Email"
    public StellarBurgersRegisterPage setUserEmail (String userEmail) {
        inputUserEmail.shouldBe(Condition.enabled);
        inputUserEmail.click();
        inputUserEmail.setValue(userEmail);
        return this;
    }

    // метод ввода для поля "Password"
    public StellarBurgersRegisterPage setUserPassword (String userPassword) {
        inputUserPassword.shouldBe(Condition.enabled);
        inputUserPassword.click();
        inputUserPassword.setValue(userPassword);
        return this;
    }

    // метод клика по кнопке "Зарегистрироваться"
    public StellarBurgersLoginPage  clickButtonUserRegistration() {
        buttonUserRegistration.click();

        return page(StellarBurgersLoginPage.class);
    }

    // метод клика для ссылки "Уже зарегистрированы? Войти"
    public StellarBurgersLoginPage clickLinkToLoginForm() {
        linkToLoginForm.click();
        return page(StellarBurgersLoginPage.class);
    }

    // метод клика для проверки пароля на корректность на странице регистрации
    public StellarBurgersRegisterPage clickCheckPassword() {
        checkPassword.click();
        return this;
    }

    // метод для заполнения полей формы регистрации
    public StellarBurgersRegisterPage fillRegistrationForm(String userName,String userEmail,String  userPassword) {

        setUserName(userName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        return this;
    }

}

