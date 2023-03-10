package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    private final WebDriver driver;

    //  локатор dropdown
    public Boolean isPanelVisible(int index) {
        By locator = By.id("accordion__panel-" + index);
        return driver.findElement(locator).isDisplayed();
    }

    // метод клика на стрелку
    public void clickPanel(int index) {
        By locator = By.id("accordion__heading-" + index);
        driver.findElement(locator).click();
    }

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextFromAnswer(int index) {
        By locator = By.id("accordion__heading-" + index);
        return driver.findElement(locator).getText();
    }

    public String getTextFromQuestion(int index) {
        By locator = By.id("accordion__panel-" + index);
        return driver.findElement(locator).getText();
    }

}
