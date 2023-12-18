package org.example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MainTest {
    @Before
    public void setUp() {
        Main.SetupWebDriver("chrome", Main.UrlBase);
    }

    @Test
    public void testLoginComCredenciaisValidas() {
        Main.TesteLogin("talliasousa.com@gmail.com", "1307");
    }
    @Test
    public void testLoginComCredenciaisInvalidas(){
        Main.TesteLogin(" ", " ");
    }


    @After
    public void tearDown() {
        if (Main.driver != null) {
            Main.driver.quit();
        }
    }

}