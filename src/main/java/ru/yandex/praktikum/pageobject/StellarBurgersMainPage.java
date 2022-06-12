package ru.yandex.praktikum.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class StellarBurgersMainPage {

    //  локатор для меню "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private SelenideElement linkToPersonalCabinet;

    //  локатор для логотипа "Stellar_Burgers"
    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;

    //  локатор для кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonGoToLoginForm;

    //  локатор для кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text() = 'Оформить заказ']")
    private SelenideElement buttonCreateOrder;

    //  локатор для заголовка "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1 [text()= 'Соберите бургер']")
    private SelenideElement headerCreateBurger ;

    //  локатор для ссылки меню "Булки"
    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Булки']")
    private SelenideElement linkOrderBun;

    //  локатор для ссылки меню "Соусы"
    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Соусы']")
    private SelenideElement linkOrderSauces;

    //  локатор для ссылки меню "Начинки"
    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Начинки']")
    private SelenideElement linkOrderFilling;

    //  локатор для подтверждения нахождения в подразделе меню "Булки"
    @FindBy(how = How.XPATH, using = "//h2[text()= 'Булки']")
    private SelenideElement headerLocatorBun;

    //  локатор для подтверждения нахождения в подразделе меню "Соусы"
    @FindBy(how = How.XPATH, using = "//h2[text()= 'Соусы']")
    private SelenideElement headerLocatorSauces;

    //  локатор для подтверждения нахождения в подразделе меню "Начинки"
    @FindBy(how = How.XPATH, using = "//h2[text()= 'Начинки']")
    private SelenideElement headerLocatorFilling;


    //      ***********************  методы  для локаторов ******************

    //  метод клика для меню "Личный кабинет"
    public StellarBurgersLoginPage clickLinkToPersonalCabinet() {
        linkToPersonalCabinet.click();
        return page(StellarBurgersLoginPage.class);
    }

    //  метод клика для меню "Личный кабинет", если пользователь авторизован
    public StellarBurgersPersonalCabinetPage clickLinkToPersonalCabinetAuthorization() {
        linkToPersonalCabinet.click();
        return page(StellarBurgersPersonalCabinetPage.class);
    }

    //  метод клика для кнопки "Войти в аккаунт"
    public StellarBurgersLoginPage clickButtonGotoLoginForm() {
        buttonGoToLoginForm.click();
        return page(StellarBurgersLoginPage.class);
    }

    //  метод для окна подтверждения логина пользователя (переход на главную страницу)
    public Boolean isConfirmThatMainPageIsDisplayed(){
        headerCreateBurger.shouldBe(Condition.visible);
        headerCreateBurger.isDisplayed();
        return headerCreateBurger.isDisplayed();
    }

    //  метод клика по ссылке меню "Булки"
    public StellarBurgersMainPage clickLinkOrderBun() {
        linkOrderBun.click();
        return this;
    }

    //  метод клика по ссылке меню "Соусы"
    public StellarBurgersMainPage clickLinkOrderSauces() {
        linkOrderSauces.click();
        return this;
    }

    //  метод клика по ссылке меню "Начинки"
    public StellarBurgersMainPage clickLinkOrderFilling() {
        linkOrderFilling.click();
        return this;
    }

    //  метод подтверждения нахождения в подразделе меню "Булки"
    public Boolean isConfirmThatHeaderBunIsDisplayed(){
        headerLocatorBun.shouldBe(Condition.visible);
        headerLocatorBun.isDisplayed();
        return headerLocatorBun.isDisplayed();
    }

    //  метод подтверждения нахождения в подразделе меню "Соусы"
    public Boolean isConfirmThatHeaderSaucesIsDisplayed(){
        headerLocatorSauces.shouldBe(Condition.visible);
        headerLocatorSauces.isDisplayed();
        return headerLocatorSauces.isDisplayed();
    }

    //  метод подтверждения нахождения в подразделе меню "Начинки"
    public Boolean isConfirmThatHeaderFillingIsDisplayed(){
        headerLocatorFilling.shouldBe(Condition.visible);
        headerLocatorFilling.isDisplayed();
        return headerLocatorFilling.isDisplayed();
    }
}
