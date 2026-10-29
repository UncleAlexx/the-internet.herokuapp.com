package tests.interfaces;

import org.openqa.selenium.WebDriver;

public interface AbstractDriver<T extends WebDriver> {
    T getDriver();
}
