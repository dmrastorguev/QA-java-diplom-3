package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.UserApiClient;
import ru.yandex.praktikum.api.UserRegister;
import ru.yandex.praktikum.pageobject.StellarBurgersMainPage;
import ru.yandex.praktikum.utils.ConfigurationBrowser;
import ru.yandex.praktikum.utils.UserGeneration;

import java.io.IOException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class UserLoginTest {

    private UserGeneration userGeneration;
    private UserApiClient userApiClient;
    private UserRegister userRegister;
    private String accessToken;
    WebDriver driver;
    @Before
    public void startUp() throws IOException {
//      Метод setBrowserName может запускать тест в разных браузерах в зависимости от передаваемого значения browserName.
//      Для вызова браузера Chrome значения browserName = "chrome", для вызова Яндекс браузера значения browserName = "yandex"
        ConfigurationBrowser configBrowser = new ConfigurationBrowser();
        configBrowser.setBrowserName("yandex");

//      Создание пользователя
        userApiClient = new UserApiClient();
        userGeneration = new UserGeneration();
        userRegister = new UserRegister(userGeneration.userName(),userGeneration.userEmail(),userGeneration.userPassword());

        ValidatableResponse userCreateResponse = userApiClient.register(new UserRegister(userRegister.getName(), userRegister.getEmail(), userRegister.getPassword()));
        accessToken = userCreateResponse.extract().path("accessToken");

    }

    @After
    public void tearDown() {
//      Удаляем созданного пользователя
        userApiClient.deleteForLogin(accessToken);
        ConfigurationBrowser configBrowser = new ConfigurationBrowser();
        configBrowser.setYandexBrowserProperties();
    }


    @Test
    @DisplayName("Тест на проверку входа пользователя - 'Вход по кнопке «Войти в аккаунт» на главной'") // имя теста
    @Description("Тест на проверку входа пользователя в систему по кнопке «Войти в аккаунт» на главной странице'") // описание теста
    public void userLoginEnterToSystem()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickButtonGotoLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку "Войти" осуществил переход на страницу /main
        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }

    @Test
    @DisplayName("Тест на проверку входа пользователя через кнопку «Личный кабинет»") // имя теста
    @Description("Тест на проверку входа пользователя в систему через кнопку «Личный кабинет» на главной странице'") // описание теста
    public void userLoginPersonalCabinet()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку "Войти" осуществил переход на страницу /main
        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }


    @Test
    @DisplayName("Тест на проверку входа пользователя через ссылку 'Уже зарегистрированы? Войти'") // имя теста
    @Description("Тест на проверку входа пользователя в систему через ссылку'Уже зарегистрированы? Войти' на странице регистрации") // описание теста
    public void userLoginAlreadyRegistryLink()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .clickLinkRegistration()
                .clickLinkToLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку "Войти" осуществил переход на страницу /main
        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }

    @Test
    @DisplayName("Тест на проверку входа пользователя через ссылку'Вспомнили пароль? Войти'") // имя теста
    @Description("Тест на проверку входа пользователя в систему через кнопку 'Вспомнили пароль? Войти' на странице восстановления пароля") // описание теста
    public void userLoginForgotPasswordLink()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .clickLinkRepairPassword()
                .clickLinkToLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку "Войти" осуществил переход на страницу /main
        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }


}
