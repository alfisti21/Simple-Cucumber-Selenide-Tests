package com.jello.pageobjects;

import org.openqa.selenium.By;

public class TrackPage {
    public static final By TRACKING_CONTAINER = By.xpath("//div[@class='tracking-main-container']");
    public static final By DUPLICATE_ORDER_LINK = By.xpath("//div[@class='tracking-main-container']//a");
    public static final By SPINNER = By.xpath("//div[@class='spinner__image']");
    public static final By ORDER_TABLE = By.xpath("//table//tbody");
    public static final By ERROR_NOTIFICATION_MESSAGE = By.xpath("//div[@class='notification__message']");
    public static final String ORDER_TABLE_ROW = "//table//tbody//tr[%s]//button";
}
