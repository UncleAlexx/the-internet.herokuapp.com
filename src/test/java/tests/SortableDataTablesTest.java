package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.testHelpers.ComparableHelpers;
import java.util.Comparator;

import static org.testng.Assert.*;

public class SortableDataTablesTest extends EdgeTestBase {
    public SortableDataTablesTest() {
        super("https://the-internet.herokuapp.com/tables#edit");
    }

    public void checkSurnamesShouldBeInNonAlphabetOrder() throws InterruptedException {

        WebElement span = getDriver().findElement(By.xpath("//table[@id='table1']/thead/tr[1]/th[1]"));
        if(span.getAttribute("class").equals("header headerSortDown"))
        {
            span.findElement(By.xpath("//span[text()='Last Name']")).click();
        }
        String[] surnames = getDriver().findElements
            (By.xpath("//table[@id='table1']//tr//td[1]")).stream().
            map(WebElement::getText).toArray(String[]::new);

        assertFalse(ComparableHelpers.isSorted(surnames, Comparator.comparing(String::toLowerCase)));
    }

    public void checkSurnamesShouldBeInAlphabetOrderAfterSorting() throws InterruptedException {
        WebElement span = getDriver().findElement(By.xpath("//table[@id='table1']/thead/tr[1]/th[1]"));
        if(span.getAttribute("class").equals("header headerSortUp") || span.getAttribute("class").equals("header"))
        {
            span.findElement(By.xpath("//span[text()='Last Name']")).click();
        }
        String[] surnames = getDriver().findElements
            (By.xpath("//table[@id='table1']//tr//td[1]")).stream().
             map(WebElement::getText).toArray(String[]::new);
        assertTrue(ComparableHelpers.isSorted(surnames, Comparator.comparing(String::toLowerCase)));
    }
}
