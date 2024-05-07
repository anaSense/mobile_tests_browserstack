package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriverProvider;
import drivers.DeviceDriverProvider;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.ConstantsHelper.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("deviceHost", BROWSERSTACK_DRIVER)) {
            case BROWSERSTACK_DRIVER -> Configuration.browser = BrowserstackDriverProvider.class.getName();
            case EMULATOR_DRIVER, LOCAL_DRIVER -> Configuration.browser = DeviceDriverProvider.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();
        if (System.getProperty("deviceHost").equals(BROWSERSTACK_DRIVER))
            AttachHelper.addVideo(sessionId);
    }
}
