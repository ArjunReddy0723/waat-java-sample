import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SampleTest {

    @Test
    public void SampleTest(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://essenceoftesting.blogspot.in/");
        driver.findElement(By.cssSelector("input#search")).sendKeys("BDT");
        driver.close();
        driver.quit();
    }

}
