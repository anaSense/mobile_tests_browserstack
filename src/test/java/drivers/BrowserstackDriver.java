package drivers;

import config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import com.codeborne.selenide.WebDriverProvider;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;


import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appium:app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("appium:deviceName", driverConfig.deviceName());
        caps.setCapability("appium:platformVersion", driverConfig.platformVersion());
        caps.setCapability("appium:projectName", "First Java Project");
        caps.setCapability("appium:buildName", "browserstack-build-1");
        caps.setCapability("appium:name", "first_test");

        try {
            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub",
                    driverConfig.userName() , driverConfig.accessKey())), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
