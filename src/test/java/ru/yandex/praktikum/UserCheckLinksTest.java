package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.api.UserApiClient;
import ru.yandex.praktikum.api.UserRegister;
import ru.yandex.praktikum.pageobject.StellarBurgersMainPage;
import ru.yandex.praktikum.utils.ConfigurationBrowser;
import ru.yandex.praktikum.utils.UserGeneration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class UserCheckLinksTest {

    private UserGeneration userGeneration;
    private UserApiClient userApiClient;
    private UserRegister userRegister;
    private String accessToken;

    @Before
    public void startUp() {
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
    }


    @Test
    @DisplayName("Тест на проверку переход по клику на «Личный кабинет» - авторизированный пользователь") // имя теста
    @Description("Тест на проверку переход по клику на «Личный кабинет» на главной странице, в случае, когда пользователь авторизирован в системе") // описание теста
    public void userCheckLinkPersonalCabinet()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatPersonalCabinetLinkIsSuccessful = stellarBurgersMainPage.clickButtonGotoLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .clickLinkToPersonalCabinetAuthorization()
                .isConfirmThatPersonalCabinetPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку «Личный кабинет» осуществил переход на страницу "Личный кабинет" (/account/profile)
        assertTrue("Сожалею,что то пошло не так. Переход по клику на «Личный кабинет» не удался", isConfirmThatPersonalCabinetLinkIsSuccessful);
    }

    @Test
    @DisplayName("Тест на проверку перехода из «Личного кабинета» по нажатию на логотип «Stellar Burgers» ") // имя теста
    @Description("Тест на проверку перехода из «Личного кабинета» по нажатию на логотип «Stellar Burgers» на главную страницу") // описание теста
    public void userCheckLinkLogoStellarBurgers()  {

//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmLogoStellarBurgersIsSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .clickLinkToPersonalCabinetAuthorization()
                .clickLogoStellarBurgers()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после нажатия на логотип «Stellar Burgers» осуществил переход на главную страницу
        assertTrue("Сожалею,что то пошло не так.Переход по нажатию на логотип «Stellar Burgers» не удался", isConfirmLogoStellarBurgersIsSuccessful);
    }

    @Test
    @DisplayName("Тест на проверку перехода из «Личного кабинета» в «Конструктор»") // имя теста
    @Description("Тест на проверку переход перехода из «Личного кабинета» в «Конструктор»") // описание теста
    public void userCheckLinkConstructor()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatButtonConstructorPushIsSuccessful = stellarBurgersMainPage.clickLinkToPersonalCabinet()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .clickLinkToPersonalCabinetAuthorization()
                .clickButtonConstructor()
                .isConfirmThatMainPageIsDisplayed();

//      проверка, что пользователь после перехода из «Личного кабинета» в «Конструктор» осуществил переход на главную страницу
        assertTrue("Сожалею,что то пошло не так. Переход по клику на кнопке «Конструктор» не удался", isConfirmThatButtonConstructorPushIsSuccessful);
    }


    @Test
    @DisplayName("Тест на проверку выхода пользователя по кнопке «Выйти» из «Личного кабинета»") // имя теста
    @Description("Тест на проверку выхода пользователя по кнопке «Выйти» из «Личного кабинета» и проверка перехода на страницу логина") // описание теста
    public void userLogout()  {
//      Подготавливаем данные для теста
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

//      Открываем главную страницу
        StellarBurgersMainPage stellarBurgersMainPage = open(baseUrl, StellarBurgersMainPage.class);
        boolean  isConfirmThatLogoutIsOk = stellarBurgersMainPage.clickButtonGotoLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .clickLinkToPersonalCabinetAuthorization()
                .clickButtonLogout()
                .isConfirmThatLoginPageIsDisplayed();

//      проверка, что пользователь после нажатия на кнопку «Выйти» из «Личного кабинета»" осуществил переход на страницу логина"
        assertTrue("Сожалею,что то пошло не так. Выход из «Личного кабинета» в систему не удался", isConfirmThatLogoutIsOk);
    }
}
