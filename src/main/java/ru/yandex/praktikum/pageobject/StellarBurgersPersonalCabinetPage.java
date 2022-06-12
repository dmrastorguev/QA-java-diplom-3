package ru.yandex.praktikum.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class StellarBurgersPersonalCabinetPage {

    //  локатор для кнопки "Выйти"
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement buttonLogout;

    //  локатор для ссылки "Профиль"
    @FindBy(how = How.XPATH, using = "//a[@href = '/account/profile']")
    private SelenideElement linkToAccountProfile;

    //  локатор для логотипа "Stellar_Burgers"
    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;

    //  локатор для кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[text()= 'Конструктор']")
    private SelenideElement buttonConstructor;


    //      ***********************  методы  для локаторов ******************

    // метод клика для кнопки "Выйти"
    public StellarBurgersLoginPage clickButtonLogout() {
        buttonLogout.click();
        return page(StellarBurgersLoginPage.class);
    }

    //  метод для окна подтверждения перехода пользователя на страницу "Личный кабинет" (/account/profile)
    public Boolean isConfirmThatPersonalCabinetPageIsDisplayed(){
        linkToAccountProfile.shouldBe(Condition.visible);
        linkToAccountProfile.isDisplayed();
        return linkToAccountProfile.isDisplayed();
    }

    //  метод клика для логотипа "Stellar_Burgers"
    public StellarBurgersMainPage clickLogoStellarBurgers() {
        logoStellarBurgers.click();
        return page(StellarBurgersMainPage.class);
    }

    //  метод клика для кнопки "Конструктор"
    public StellarBurgersMainPage clickButtonConstructor() {
        buttonConstructor.click();
        return page(StellarBurgersMainPage.class);
    }
}
