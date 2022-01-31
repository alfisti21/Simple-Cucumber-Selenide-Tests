package com.jello.pageobjects;

import org.openqa.selenium.By;

public class LocationLanguagePage {
    public static final By LOCATION_PAGE_TITLE = By.xpath("//h1");
    public static final By GREEK_LANGUAGE = By.xpath("//a[text()='Ελληνικά']");
    public static final By RANDOM_ELEMENT_GREEK = By.xpath("//span[text()='ΕΝΤΟΠΙΣΜΟΣ']");
}
