package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ConstantsHelper.BROWSERSTACK_DRIVER;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.apache.commons.io.IOUtils.skip;
import static org.openqa.selenium.By.id;

public class SearchTests extends TestBase {
    @Test
    void successfulSearchTest() {
        if(!System.getProperty("deviceHost", BROWSERSTACK_DRIVER)
                .equals(BROWSERSTACK_DRIVER))
            step("Close getting started screen", () -> back());

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();

            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Verify content", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
    }
}
