package helpers;

import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(driverConfig.userName(), driverConfig.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
