package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.StellarBurgersMainPage;
import ru.yandex.praktikum.utils.ConfigurationBrowser;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class UserCheckMenuTest {

    @Before
    public void startUp() {
//      Метод setBrowserName может запускать тест в разных браузерах в зависимости от передаваемого значения browserName.
//      Для вызова браузера Chrome значения browserName = "chrome", для вызова Яндекс браузера значения browserName = "yandex"
        ConfigurationBrowser configBrowser = new ConfigurationBrowser();
        configBrowser.setBrowserName("yandex");
    }

    @Test
    @DisplayName("Тест на проверку перехода по нажатию на ссылку меню 'Булки' в раздел меню 'Булки'") // имя теста
    @Description("Тест на проверку переход по нажатию на ссылку меню 'Булки' в раздел меню 'Булки'") // описание теста
    public void userCheckLinkToMenuBun() {

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatHeaderBunIsDisplayed = stellarBurgersMainPage.clickLinkOrderFilling()
                .clickLinkOrderBun()
                .isConfirmThatHeaderBunIsDisplayed();

//      проверка, что пользователь после нажатия на ссылку меню "Булки" осуществил переход в раздел меню "Булки"
        assertTrue("Сожалею,что то пошло не так. Переход в раздел меню 'Булки' не удался", isConfirmThatHeaderBunIsDisplayed);
    }

    @Test
    @DisplayName("Тест на проверку перехода по нажатию на ссылку меню 'Соусы' в раздел меню 'Соусы'") // имя теста
    @Description("Тест на проверку переход по нажатию на ссылку меню 'Соусы' в раздел меню 'Соусы'") // описание теста
    public void userCheckLinkToMenuSauces() {

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatHeaderSaucesIsDisplayed = stellarBurgersMainPage.clickLinkOrderSauces()
                .isConfirmThatHeaderSaucesIsDisplayed();

//      проверка, что пользователь после нажатия на ссылку меню "Соусы" осуществил переход в раздел меню "Соусы"
        assertTrue("Сожалею,что то пошло не так. Переход в раздел меню 'Соусы' не удался", isConfirmThatHeaderSaucesIsDisplayed);
    }


    @Test
    @DisplayName("Тест на проверку перехода по нажатию на ссылку меню 'Начинки' в раздел меню 'Начинки'") // имя теста
    @Description("Тест на проверку переход по нажатию на ссылку меню 'Начинки' в раздел меню 'Начинки'") // описание теста
    public void userCheckLinkToMenuFilling() {

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatHeaderFillingIsDisplayed = stellarBurgersMainPage.clickLinkOrderFilling()
                .isConfirmThatHeaderFillingIsDisplayed();

//      проверка, что пользователь после нажатия на ссылку меню "Начинки" осуществил переход в раздел меню "Начинки"
        assertTrue("Сожалею,что то пошло не так. Переход в раздел меню 'Начинки' не удался", isConfirmThatHeaderFillingIsDisplayed);
    }
}

