import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.sql.DriverManager.println;

public class SampleTest {

    @Test
    public void SampleTest(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://essenceoftesting.blogspot.in/");
        driver.findElement(By.cssSelector(".Classic")).click();
        driver.close();
        driver.quit();
    }

}
