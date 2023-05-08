import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.os.ExecutableFinder;

import java.io.File;


public class TestClass1 extends FluentTest{

    @Override
    public String getWebDriver()
    {
        return "chrome";
    }

    @Override
    public Capabilities getCapabilities()
    {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        return options;
    }

    @BeforeClass
    public static void setup() {
            WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test1()
    {
        LocalFileDetector fileDetector = new LocalFileDetector();
        goTo("https://ps.uci.edu/~franklin/doc/file_upload.html");
        File file = fileDetector.getLocalFile("out/test/resources/back.pdf");
        getDriver().findElement(By.xpath("//input[@name='userfile']")).sendKeys(file.getAbsolutePath());


    }



}
