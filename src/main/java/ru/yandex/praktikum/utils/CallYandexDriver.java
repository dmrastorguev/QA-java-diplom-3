package ru.yandex.praktikum.utils;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.WebDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CallYandexDriver implements WebDriverProvider {

    @NotNull
    @Override
    public WebDriver createDriver(@NotNull DesiredCapabilities desiredCapabilities) {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        return driver = new ChromeDriver();
    }
}