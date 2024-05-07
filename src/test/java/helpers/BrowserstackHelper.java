package helpers;

import config.BrowserstackAuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    static BrowserstackAuthConfig browserstackConfig = ConfigFactory.create(BrowserstackAuthConfig.class,
            System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfig.userName(), browserstackConfig.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
