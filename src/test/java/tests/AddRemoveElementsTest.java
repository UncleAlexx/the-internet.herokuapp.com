package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class AddRemoveElementsTest extends EdgeTestBase {
    public AddRemoveElementsTest(){
        super("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void oneButtonShouldLeftAfterTwoAddedOneRemoved() {
        WebElement addButtonOnClickButton = getDriver().findElement(
            By.xpath("//button[@onclick='addElement()']"));
        addButtonOnClickButton.click();
        addButtonOnClickButton.click();
        List<WebElement> addedElems = getDriver().findElements(By.
            xpath("//button[@class = 'added-manually' and @onclick='deleteElement()']"));
        addedElems.getFirst().click();

        assertEquals(1, getDriver().findElements(By.
            xpath("//button[@class = 'added-manually' and @onclick='deleteElement()']")).
                size());
    }
}
