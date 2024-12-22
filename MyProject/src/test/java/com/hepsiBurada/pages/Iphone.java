package com.hepsiBurada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Iphone extends BasePage {

    @FindBy(css = "a.yPPu6UogPlaotjhx1Qki")
    public WebElement degerlendirmeler;

    @FindBy(xpath = "//div[.='Varsayılan']")
    public WebElement dropDown;

    @FindBy(xpath = "//div[.='En yeni değerlendirme']")
    public WebElement enYeniDegerlendirme;

    @FindBy(css = ".thumbsUp")
    public WebElement thumbsUp;

    @FindBy(css = ".hermes-ReviewCard-module-QA5PqdPP5EhkpY_vptfv")
    public List<WebElement> tesekkur;

}
