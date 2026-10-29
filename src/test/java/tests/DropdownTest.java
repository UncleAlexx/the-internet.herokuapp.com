package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public class DropdownTest extends EdgeTestBase {
    public DropdownTest() {
        super("http://the-internet.herokuapp.com/dropdown");
    }

    public void optionsShouldBePresent(){
        assertFalse(getDriver().findElement(By.id("dropdown")).
                findElements(By.tagName("option")).isEmpty());
    }

    public void firstShouldBeSelectedAfterSelection(){
        WebElement firstOption = getDriver().
            findElement(By.xpath("//select[@id='dropdown']//option[@value='1']"));
        firstOption.click();
        assertTrue(firstOption.isSelected());
    }

    public void secondShouldBeSelectedAfterSelection(){
        WebElement secondOption = getDriver().
                findElement(By.xpath("//select[@id='dropdown']//option[@value='2']"));
        secondOption.click();
        assertTrue(secondOption.isSelected());
    }
}
