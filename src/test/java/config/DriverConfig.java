package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/driver.properties"
})
public interface DriverConfig extends Config {
    @Key("userName")
    String userName();
    @Key("accessKey")
    String accessKey();
    @Key("deviceName")
    String deviceName();
    @Key("platformVersion")
    String platformVersion();
}
