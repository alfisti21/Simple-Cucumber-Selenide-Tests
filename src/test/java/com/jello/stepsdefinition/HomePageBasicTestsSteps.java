package com.jello.stepsdefinition;

import java.util.Objects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.jello.pageobjects.LocationLanguagePage.*;
import static com.jello.pageobjects.SearchPage.PAGINATION;
import static com.jello.pageobjects.SearchPage.SEARCH_CONTAINER;
import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.jello.pageobjects.HomePage.*;
import static com.jello.pageobjects.LoginPage.LOGIN_PAGE_TITLE;
import static com.jello.pageobjects.TrackPage.*;
import static java.lang.String.format;

public class HomePageBasicTestsSteps {
    @Then("I verify that the location asking pop-up is present")
    public void iVerifyLocationPopUp() {
        $(LANGUAGE_POP_UP).shouldBe(visible);
        $(LANGUAGE_POP_UP_TITLE).shouldHave(text("Choose your location"));
    }

    @And("I dismiss the pop-up and cookies")
    public void iDismissThePopUpAndCookies() {
        $(LANGUAGE_POP_UP_CLOSE).click();
        $(ACCEPT_COOKIES).click();
    }

    @When("I provide {string} as tracking ID in {string}")
    public void iProvideAsTrackingIDAndProceed(String trackingId, String where) {
        if(Objects.equals(where, "main page")){
            $(TRACKING_ID_INPUT).sendKeys(trackingId);
        }else{
            $(TRACKING_ID_INPUT_NAVIGATION_PANE).sendKeys(trackingId);
            $(TRACK_BUTTON_NAVIGATION_PANE).click();
        }
        if($(TRACK_BUTTON).isDisplayed()){
            $(TRACK_BUTTON).click();
        } //Sometimes the process of tracking an order starts on its own when an ID is pasted
        sleep(3000);
    }

    @Then("I verify the result")
    public void iVerifyResult(){
        $(TRACKING_CONTAINER).shouldBe(visible);
        if(!$(ERROR_NOTIFICATION_MESSAGE).isDisplayed()){ //the tracking id used in this test returns different results
            //when it runs from my IDE. This code in the if statement most probably will not be executed.
            $(SPINNER).shouldBe(visible);
            //sleep(2000);
            $(DUPLICATE_ORDER_LINK).shouldBe(visible);
            $(DUPLICATE_ORDER_LINK).click();
            $(ORDER_TABLE).shouldBe(visible);
            $x(format(ORDER_TABLE_ROW, "3")).click();
        } else {
            $(ERROR_NOTIFICATION_MESSAGE).shouldHave(text(" Unfortunately, we are unable to retrieve your tracking" +
                    " results at this time. Please try again later. "));
        }
    }

    @And("I click Tracking on the navigation pane")
    public void iClickTrackingNavPane(){
        $(TRACKING_NAVIGATION_PANE).click();
    }

    @And("I switch to the calculator module")
    public void iClickCalculator(){
        $(CALCULATOR_BUTTON).click();
        sleep(4000);
    }

    @Then("I provide 'from' and 'to' addresses")
    public void iProvideAddresses(){
        $(RATES_TITLE).shouldBe(visible);
        $(FROM_ADDRESS_INPUT).shouldBe(visible);
        $(FROM_ADDRESS_INPUT).sendKeys("Heraklion, 14121, Greece");
        $(ADDRESS_SUGGESTION).shouldBe(visible);
        $(ADDRESS_SUGGESTION).click();
        sleep(1000);
        $(TO_ADDRESS_INPUT).sendKeys("Amsterdam, 1061AX, Netherlands");
        $(ADDRESS_SUGGESTION).click();
        sleep(1000);
    }

    @And("I choose package")
    public void iChoosePackage(){
        $(PACKAGING_TYPES).shouldBe(visible);
        $x(format(PACKAGING_TYPE_OPTION, "2")).click();
        $(PACKAGE_WEIGHT).sendKeys("9");
        $(SHOW_RATES_BUTTON).click();
    }

    @Then("I validate rates results")
    public void iValidateRates(){
        $(RATES_SUMMARY_TITLE).shouldBe(visible);
        $(SHIPPING_OPTIONS).shouldBe(visible);
    }

    @And("I switch to the shipping page")
    public void iClickShipping(){
        $(SHIPPING_BUTTON).click();
    }

    @Then("I confirm I end up in login page")
    public void iConfirmRedirection(){
        $(LOGIN_PAGE_TITLE).shouldBe(visible);
        assertEquals("https://www.fedex.com/secure-login/en-gb/#/login-credentials", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Then("I open the chat bot and confirm there is an initial message")
    public void iOpenChatBotAndConfirmMessage(){
        $(CHAT_BOT).shouldBe(visible);
        $(CHAT_BOT).click();
        $(CHAT_BOT_LATEST_AGENT_ANSWER).shouldBe(visible);
        assertEquals(firstBotMessage, $(CHAT_BOT_LATEST_AGENT_ANSWER).getText());
    }

    @And("I type a hint")
    public void iTypeHint(){
        $(CHAT_BOX_TEXT_INPUT).sendKeys("Tracking");
        $(CHAT_BOX_SUBMIT).click();
        sleep(1000);
    }

    @Then("I check there is a relevant bot response")
    public void iVerifyBotResponse(){
        $(CHAT_BOT_LATEST_AGENT_ANSWER).shouldBe(visible);
        assertEquals(botReply, $(CHAT_BOT_LATEST_AGENT_ANSWER).getText());
    }

    @And("I navigate to search and look up for {string}")
    public void iNavigateAndSubmitSearchWord(String keyWord){
        $(SEARCH_ICON).shouldBe(visible);
        $(SEARCH_ICON).click();
        $(SEARCH_TEXT_INPUT).shouldBe(visible);
        $(SEARCH_TEXT_INPUT).sendKeys(keyWord);
        $(SEARCH_TEXT_INPUT).sendKeys(Keys.ENTER);
    }

    @Then("I verify the search results")
    public void iVerifySearchResults(){
        $(SEARCH_CONTAINER).shouldBe(visible);
        $(PAGINATION).shouldBe(visible);
        //TODO - Here we can expand the test and start checking if sorting works for example
    }

    @Then("I verify 'Manage your shipment' is visible")
    public void iVerifyManageShipmentSection(){
        $(MANAGE_SHIPMENT_SECTION).shouldBe(visible);
        $$(MANAGE_SHIPMENT_SECTION).shouldHave(size(5));
    }

    @And("I check that I am redirected properly to those pages")
    public void iCheckProperRedirection(){
        for(int i=1; i<6; i++){
            $x(format(MANAGE_SHIPMENT_SECTION_ITEMS, i)).click();
            assertEquals(MANAGE_SHIPMENT_REDIRECTION_URLS[i-1], WebDriverRunner.getWebDriver().getCurrentUrl());
            back();
        }
    }

    @Then("I verify latest news section is present")
    public void iVerifyNewsPresent(){
        $(LATEST_NEWS_SECTION).shouldBe(visible);
        $(LATEST_NEWS_SECTION).scrollIntoView(true);
        $(LATEST_NEWS_LINKS).shouldBe(visible);
    }

    @And("I check the 'More News' option and verify")
    public void iCheckMoreNews(){
        $(MORE_NEWS).click();
        //TODO - Add more steps when More News link is fixed
    }

    @When("I click the location-language link and change")
    public void iChangeLocationLanguage(){
        $(LANGUAGE_BUTTON).click();
        $(LOCATION_PAGE_TITLE).shouldBe(visible);
        $(GREEK_LANGUAGE).click();
    }

    @Then("I verify I am redirected and language is changed")
    public void iVerifyLocationLanguageChange(){
        assertEquals("https://www.fedex.com/el-gr/home.html", WebDriverRunner.getWebDriver().getCurrentUrl());
        $(RANDOM_ELEMENT_GREEK).shouldBe(visible);
    }
}
