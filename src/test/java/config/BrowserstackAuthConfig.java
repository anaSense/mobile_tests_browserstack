package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack_auth_driver.properties"
})
public interface BrowserstackAuthConfig extends Config {
    @Key("userName")
    String userName();
    @Key("accessKey")
    String accessKey();
}
