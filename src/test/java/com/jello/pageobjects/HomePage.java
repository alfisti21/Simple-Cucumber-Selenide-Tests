package com.jello.pageobjects;

import org.openqa.selenium.By;

public class HomePage {
    public static final By CHAT_BOT = By.xpath("//div[@class='va_icon']");
    public static final By CHAT_BOT_LATEST_AGENT_ANSWER = By.xpath("//div[@class='nw_AgentSays nw_AgentLastAnswer']");
    public static final By CHAT_BOX_LATEST_USER_ANSWER = By.xpath("//div[@class='nw_UserSays'][last()]");
    public static final By CHAT_BOX_TEXT_INPUT = By.xpath("//textarea[@class='nw_UserInputField']");
    public static final By CHAT_BOX_SUBMIT = By.xpath("//div[@class='nw_Input']//div[2]");
    public static final By LANGUAGE_POP_UP = By.xpath("//div[@class = 'fxg-u-modal__wrapper u-scroll-vertical']");
    public static final By LANGUAGE_POP_UP_TITLE = By.xpath("//div[@class = 'fxg-u-modal__wrapper u-scroll-vertical']//h3");
    public static final By LANGUAGE_POP_UP_CLOSE = By.xpath("//a[@title='close']");
    public static final By TRACKING_ID_INPUT = By.xpath("//input[@name='trackingnumber']");
    public static final By TRACK_BUTTON = By.xpath("//form//div//button[@type='submit']");
    public static final By ACCEPT_COOKIES = By.xpath("//button[@class = 'fxg-cookie-consent__accept fxg-button fxg-button--orange js-fxg-cookie-save is-save-all']");
    public static final By TRACKING_NAVIGATION_PANE = By.xpath("//a[@aria-label='Tracking']");
    public static final By TRACKING_ID_INPUT_NAVIGATION_PANE = By.xpath("//input[@id='trackingModuleTrackingNum']");
    public static final By TRACK_BUTTON_NAVIGATION_PANE = By.xpath("//li//button[@type='submit']");
    public static final By CALCULATOR_BUTTON = By.xpath("//li[@id='cubeOnePar']//button");
    public static final By SHIPPING_BUTTON = By.xpath("//li[@id='cubeThreePar']//button");
    public static final By FROM_ADDRESS_INPUT = By.xpath("//input[@id='fromGoogleAddress']");
    public static final By TO_ADDRESS_INPUT = By.xpath("//input[@id='toGoogleAddress']");
    public static final By PACKAGE_WEIGHT = By.xpath("//input[@id='package-details__weight-0']");
    public static final By ADDRESS_SUGGESTION = By.xpath("//ul[@id='e2eGoogleAddressSuggestionList']//li[1]");
    public static final By SHOW_RATES_BUTTON = By.xpath("//button[@id='e2ePackageDetailsSubmitButtonRates']");
    public static final By RATES_TITLE = By.xpath("//h1[@id='magr-heading']");
    public static final By RATES_SUMMARY_TITLE = By.xpath("//h5[@id='rateSummary']");
    public static final By SHIPPING_OPTIONS = By.xpath("//magr-rate-container//div//div//div//div//magr-rate-list//ul//li//li");
    public static final By PACKAGING_TYPES = By.xpath("//select[@id='package-details__package-type']");
    public static final By SEARCH_ICON = By.xpath("//div[@class='fxg-user-options']/div[2]/a");
    public static final By SEARCH_TEXT_INPUT = By.xpath("//input[@id='fxg-search-text']");
    public static final By MANAGE_SHIPMENT_SECTION = By.xpath("//div[@class='advanced_table table parbase section']//table[2]//thead//tr//th");
    public static final By LATEST_NEWS_SECTION = By.xpath("//div[@class='fxg-featured-offer__detail']");
    public static final By LATEST_NEWS_LINKS = By.xpath("//div[@class='fxg-featured-offer__detail']//div[@class='link section']");
    public static final By MORE_NEWS = By.xpath("//div[@class='featured_offer section']//div[@class='fxg-featured-offer__detail']/a");
    public static final By LANGUAGE_BUTTON = By.xpath("//div[@class='language_dropdown section']/div/a");
    public static final String PACKAGING_TYPE_OPTION = "//select[@id='package-details__package-type']//option[%s]";
    public static final String MANAGE_SHIPMENT_SECTION_ITEMS = "//div[@class='advanced_table table parbase section']//table[2]//thead//tr//th[%s]";
    public static final String firstBotMessage = "FedEx: Hello, I'm the FedEx Virtual Assistant. I'm here to help you with your questions regarding FedEx services.";
    public static final String botReply = "FedEx: In order for me to assist you with tracking your shipment, I will need your tracking number. Please select one of the options below:\n" +
            "I don’t know my tracking number\n" +
            "I know my tracking number and can provide it now";
    public static final String[] MANAGE_SHIPMENT_REDIRECTION_URLS = {"https://www.fedex.com/en-gb/service-news.html", "https://www.fedex.com/en-gb/shipping/packaging.html",
    "https://www.fedex.com/en-gb/customs-tools.html", "https://www.fedex.com/en-gb/tracking/advanced.html", "https://www.fedex.com/en-gb/billing/duty-tax.html"};
}
