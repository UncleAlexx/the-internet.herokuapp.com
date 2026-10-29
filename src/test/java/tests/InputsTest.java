package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public class InputsTest extends EdgeTestBase {
    public InputsTest() {
        super("http://the-internet.herokuapp.com/inputs");
    }

    public void checkInputValueShouldDecreaseWhenArrowDownPressed() throws InterruptedException {
        WebElement inputTypeNumber = getDriver().
                findElement(By.xpath("//div[@class='example']//input[@type='number']"));

        inputTypeNumber.sendKeys(Keys.ARROW_DOWN);

        assertEquals(inputTypeNumber.getAttribute("value"), "-1");
    }

    public void checkInputValueShouldIncreaseWhenArrowDownPressed() {
        WebElement inputTypeNumber = getDriver().findElement(By.
                xpath("//div[@class='example']//input[@type='number']"));
        inputTypeNumber.sendKeys(Keys.ARROW_UP);
        assertEquals(inputTypeNumber.getAttribute("value"), "1");
    }

    public void valueShouldBeEmptyAfterTryingToChangeItToText(){
        WebElement inputTypeNumber = getDriver().findElement(By.
                xpath("//div[@class='example']//input[@type='number']"));
        inputTypeNumber.sendKeys("ddd");
        assertEquals(inputTypeNumber.getAttribute("value"), "");
    }
}
