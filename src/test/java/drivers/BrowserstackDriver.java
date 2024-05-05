package drivers;

import io.appium.java_client.android.AndroidDriver;
import com.codeborne.selenide.WebDriverProvider;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NotNull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();
//        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        String userName = "anna_tsZfpx";
        String accessKey = "z5e8D4yJZMqqiEzoMqvD";
//        caps.setCapability("userName", "anna_tsZfpx");
//        caps.setCapability("accessKey", "z5e8D4yJZMqqiEzoMqvD");

        // Set URL of the application under test
        caps.setCapability("appium:app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        caps.setCapability("appium:deviceName", "Google Pixel 7 Pro");
        caps.setCapability("appium:platformVersion", "13.0");

        // Set other BrowserStack capabilities
        caps.setCapability("appium:projectName", "First Java Project");
        caps.setCapability("appium:buildName", "browserstack-build-1");
        caps.setCapability("appium:name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName , accessKey)), caps);


//            return new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
