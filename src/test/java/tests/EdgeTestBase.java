package tests;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import tests.interfaces.AbstractDriver;

@Test(alwaysRun = true)
public abstract class EdgeTestBase implements AbstractDriver<EdgeDriver> {
    private static final ThreadLocal<EdgeDriver> driver;

    static {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        driver = new ThreadLocal<>();
        driver.set(new EdgeDriver(options));
    }

    private final String path;

    public EdgeTestBase(String path) {
        this.path = path;
    }

    @Override
    public final EdgeDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    public void beforeTest(){
        driver.get().get(path);
    }
    @AfterSuite
    public void da(){
        driver.get().close();
    }
}
