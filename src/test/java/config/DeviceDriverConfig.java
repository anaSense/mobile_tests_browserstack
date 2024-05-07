package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${deviceHost}_driver.properties"
})
public interface DeviceDriverConfig extends Config {
    @Key("udid")
    String udid();
}
