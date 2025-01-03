package com.hepsiBurada.step_definitions;

import com.hepsiBurada.pages.Iphone;
import com.hepsiBurada.utilities.BrowserUtils;
import com.hepsiBurada.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiSteps {

    Iphone iphone = new Iphone();
    public WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(30));


    @When("Search for iphones and select a random product")
    public void searchForIphonesAndSelectARandomProduct() {
        iphone.acceptCookies();
        BrowserUtils.waitFor(3);

        iphone.searchBox.click();
        BrowserUtils.waitFor(2);

        iphone.searchBoxInput.sendKeys("iphone" + Keys.ENTER);
        BrowserUtils.waitForPageToLoad();

        iphone.selectRandomIphone();
        BrowserUtils.waitForPageToLoad();

        BrowserUtils.switchToWindow();
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

    }

    boolean degerlendirmeExist = true;

    @And("Hit değerlendirmeler and Rank according to En Yeni Değerlendirme give thumbsUp")
    public void hitDeğerlendirmelerAndRankAccordingToEnYeniDeğerlendirmeGiveThumbsUp() {

        try {
            BrowserUtils.waitForVisibility(iphone.degerlendirmeler, Duration.ofSeconds(2));
            iphone.degerlendirmeler.click();

            BrowserUtils.scrollToElement(iphone.dropDown);
            BrowserUtils.waitForVisibility(iphone.dropDown, Duration.ofSeconds(2));
            iphone.dropDown.click();

            BrowserUtils.waitForVisibility(iphone.enYeniDegerlendirme, Duration.ofSeconds(2));
            iphone.enYeniDegerlendirme.click();

            BrowserUtils.scrollToElement(iphone.thumbsUp);
            BrowserUtils.waitForVisibility(iphone.thumbsUp, Duration.ofSeconds(2));
            iphone.thumbsUp.click();
        } catch (NoSuchElementException e) {
            degerlendirmeExist = false;
        }

    }

    @Then("Verify success message as {string}")
    public void verifySuccessMessageAs(String expectedTesekkur) {

        if (degerlendirmeExist) {
            Assert.assertTrue(iphone.tesekkur.size() == 1);
            Assert.assertEquals("Teşekkür Ederiz is not displayed", expectedTesekkur, iphone.tesekkur.get(0).getText());
        }
    }
}