package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack_driver.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("deviceName")
    String deviceName();
    @Key("platformVersion")
    String platformVersion();
}
