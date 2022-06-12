package ru.yandex.praktikum.utils;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConfigurationBrowser {
    public void setBrowserName(String browserName) {
        Configuration.browser = browserName;
//        Configuration.browserSize= "1920x1080";
        Configuration.startMaximized = true;
        baseUrl = "https://stellarburgers.nomoreparties.site/";

        if (browserName == "yandex" || browserName == "Yandex"){
             setYandexBrowserProperties();
        }
    }

    public void setYandexBrowserProperties() {
        Configuration.timeout = 4000;
        Configuration.startMaximized = true;
        Configuration.browser = CallYandexDriver.class.getName();
        baseUrl = "https://stellarburgers.nomoreparties.site/";
    }
}

