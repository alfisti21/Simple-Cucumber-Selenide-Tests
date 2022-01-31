package com.jello.stepsdefinition;

import io.cucumber.java.en.Given;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    @Given("I access {string} page")
    public void iAccessPage(String url) {
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
