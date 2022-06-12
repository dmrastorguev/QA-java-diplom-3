package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.api.UserApiClient;
import ru.yandex.praktikum.pageobject.StellarBurgersMainPage;
import ru.yandex.praktikum.utils.ConfigurationBrowser;
import ru.yandex.praktikum.utils.UserGeneration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;



public class UserRegistrationTest {

    private UserGeneration userGeneration;
    private UserApiClient userApiClient;
    private String accessToken;

    @Before
    public void startUp() {
        userApiClient = new UserApiClient();
//      Метод setBrowserName может запускать тест в разных браузерах в зависимости от передаваемого значения browserName.
//      Для вызова браузера Chrome значения browserName = "chrome", для вызова Яндекс браузера значения browserName = "yandex"
        ConfigurationBrowser configBrowser = new ConfigurationBrowser();
        configBrowser.setBrowserName("yandex");
    }


    @After
    public void tearDown() {
//      Удаляем созданного пользователя
        userApiClient.delete(accessToken);
    }


    @Test
    @DisplayName("Тест на проверку создание пользователя") // имя теста
    @Description("Тест на проверку создание пользователя с корректными параметрами") // описание теста
    public void userRegisterWithCorrectParameter() throws InterruptedException {
//      Подготавливаем данные для теста
        userGeneration = new UserGeneration();
        String userName = userGeneration.userName();
        String userEmail = userGeneration.userEmail();
        String userPassword = userGeneration.userPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean isConfirmThatRegistrationSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .clickLinkRegistration()
                .fillRegistrationForm(userName, userEmail, userPassword)
                .clickButtonUserRegistration()
                .confirmThatLoginWebPageIsDisplayed()
                .fillLoginForm(userEmail, userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();
        accessToken = waitForLocalStorage();
        System.out.println(accessToken);

//      проверка, что пользователь после нажатия на кнопку "Зарегистрироваться" осуществил переход на страницу /login
        assertTrue("Сожалею,что то пошло не так. Регистрация не успешна", isConfirmThatRegistrationSuccessful);
    }


    @Test
    @DisplayName("Тест на проверку создание пользователя c не корректным паролем") // имя теста
    @Description("Тест на проверку создание пользователя с паролем, где число символов меньше 6") // описание теста
    public void userRegisterWithIncorrectParameter() {
//      Подготавливаем данные для теста
        userGeneration = new UserGeneration();
        String userName = userGeneration.userName();
        String userEmail = userGeneration.userEmail();
        String userWrongPassword = userGeneration.userWrongPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .clickLinkRegistration()
                .fillRegistrationForm(userName, userEmail, userWrongPassword)
                .clickButtonUserRegistration()
                .isConfirmThatRegistrationFalls();// Проверка подтверждения неуспешной регистрации пользователя (не найден SelenideElement на странице /login)
    }


    public String waitForLocalStorage() throws InterruptedException {

        long start_time = System.currentTimeMillis();
        long wait_time = 60000;
        long end_time = start_time + wait_time;

        while (localStorage().getItem("accessToken") != null) {
            Thread.sleep(100);

            if (System.currentTimeMillis() < end_time) {
                break;
            }
        }
        return localStorage().getItem("accessToken").substring(7);
    }
}




