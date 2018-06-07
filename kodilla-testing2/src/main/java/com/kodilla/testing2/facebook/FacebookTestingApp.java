package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_DAY = "//span[@id=\"u_0_z\"]/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//span[@id=\"u_0_z\"]/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//span[@id=\"u_0_z\"]/span/select[3]";

    public static final String XPATH_FORM_FIRSTNAME = "//div[@id=\"reg_form_box\"]/div//input";
    public static final String XPATH_FORM_LASTNAME = "//div[@id=\"reg_form_box\"]/div/div/div[2]//input";
    public static final String XPATH_FORM_EMAIL = "//div[@id=\"reg_form_box\"]/div[2]//input";
    public static final String XPATH_FORM_EMAIL2 = "//div[@id=\"reg_form_box\"]/div[3]//input";
    public static final String XPATH_FORM_PASSWORD = "//div[@id=\"reg_form_box\"]/div[5]//input";
    public static final String XPATH_FORM_GENDER = "//div[@id=\"reg_form_box\"]/div[7]/span/span[2]/input";

//    these works too
//    public static final String XPATH_FORM_FIRSTNAME = "//div[@id=\"u_0_k\"]//input";
//    public static final String XPATH_FORM_LASTNAME = "//div[@id=\"u_0_m\"]//input";
//    public static final String XPATH_FORM_EMAIL = "//div[@id=\"u_0_p\"]//input";
//    public static final String XPATH_FORM_EMAIL2 = "//div[@id=\"u_0_r\"]//input";
//    public static final String XPATH_FORM_PASSWORD = "//div[@id=\"u_0_w\"]//input";
//    public static final String XPATH_FORM_GENDER = "//div[@id=\"u_0_10\"]/span/span[2]/input";



    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(5);

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(5);

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(114);

        driver.findElement(By.xpath(XPATH_FORM_FIRSTNAME)).sendKeys("Robot");
        driver.findElement(By.xpath(XPATH_FORM_LASTNAME)).sendKeys("Robot");
        driver.findElement(By.xpath(XPATH_FORM_EMAIL)).sendKeys("robot@robot.com");
        driver.findElement(By.xpath(XPATH_FORM_EMAIL2)).sendKeys("robot@robot.com");
        driver.findElement(By.xpath(XPATH_FORM_PASSWORD)).sendKeys("robot_password");
        driver.findElement(By.xpath(XPATH_FORM_GENDER)).click();
    }
}