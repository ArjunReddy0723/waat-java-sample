package waat;

import com.thoughtworks.webanalyticsautomation.Controller;
import com.thoughtworks.webanalyticsautomation.Engine;
import com.thoughtworks.webanalyticsautomation.common.Utils;
import com.thoughtworks.webanalyticsautomation.inputdata.InputFileType;
import com.thoughtworks.webanalyticsautomation.plugins.WebAnalyticTool;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleTest {

    private Engine engine;
    private WebAnalyticTool webAnalyticTool = WebAnalyticTool.JS_SNIFFER;
    private InputFileType inputFileType = InputFileType.XML;
    private boolean keepLoadedFileInMemory = true;
    private String log4jPropertiesAbsoluteFilePath = Utils.getAbsolutePath(new String[]{"resources", "log4j.properties"});
    private String inputDataFileName = Utils.getAbsolutePath(new String[]{"resources", "sampledata", "TestData.xml"});
    private String actionName = "essenceoftesting_search_JsSniffer";
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void SampleTest(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://essenceoftesting.blogspot.in/");

        engine = Controller.getInstance(webAnalyticTool, inputFileType, keepLoadedFileInMemory,
                log4jPropertiesAbsoluteFilePath);

        driver.findElement(By.cssSelector("input#search")).sendKeys("BDT");
        String waatJSStr = "window.WAAT_URL=\"\";window.google.search;return window.WAAT_URL";
        String extractedURL = (String) ((JavascriptExecutor) driver).executeScript(waatJSStr);

        System.out.println("waat JS string: " + waatJSStr);
        System.out.println("extracted url: " + extractedURL);
        driver.close();
        driver.quit();
    }

}
