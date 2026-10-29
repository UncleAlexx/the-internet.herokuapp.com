package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public class CheckboxesTest extends EdgeTestBase {
    public CheckboxesTest(String path) throws InterruptedException {
        super("http://the-internet.herokuapp.com/checkboxes");
    }

    public void shouldBeChecked()
    {
        assertTrue(getDriver().findElement(By.xpath("//*[@id='checkboxes']/input[@type='checkbox' and @checked]")).
                isSelected());
    }
    public void shouldBeUnchecked()
    {
        assertFalse(getDriver().findElement(By.xpath("//*[@id='checkboxes']/input[@type='checkbox']")).
            isSelected());
    }

    public void shouldBeCheckedAfterSelection()
    {
        WebElement element = getDriver().findElement(By.xpath("//*[@id='checkboxes']/input[@type='checkbox']"));
        element.click();
        assertTrue(element.isSelected());
    }

    public void shouldBeUncheckedAfterDeselection()
    {
        WebElement element = getDriver().findElement(
            By.xpath("//*[@id='checkboxes']/input[@type='checkbox' and @checked]"));

        element.click();
        assertFalse(element.isSelected());
    }
}
