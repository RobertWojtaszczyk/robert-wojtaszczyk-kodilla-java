package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static final String SEARCHFIELD_BY_ID = "gh-ac";
    public static final String SEARCHFIELD_BY_NAME = "_nkw";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.com/");

//        WebElement searchField = driver.findElement(By.id(SEARCHFIELD_BY_ID)); // By.id works too
        WebElement searchField = driver.findElement(By.name(SEARCHFIELD_BY_NAME));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
