package com.mainacad.selenium.service;

import com.mainacad.selenium.model.Account;
import com.mainacad.selenium.model.User;
import com.mainacad.util.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class PromAccountService {

    private static final Logger LOG = Logger.getLogger(PromAccountService.class.getName());

    private static final String REG_URL = "https://prom.ua/join-customer";
    private static final String LOGIN_URL = "https://my.prom.ua/cabinet/sign-in";

    public static WebDriver registerAccount(Account account, WebDriver driver) {

        driver.get(REG_URL);
        Timer.waitSeconds(10);

//        List<WebElement> regForm = driver.findElements(By.tagName("form")).
//                stream().filter(element -> element.getAttribute("data-qaid") != null &&
//                element.getAttribute("data-qaid").equals("register_form")).
//                collect(Collectors.toList());

        List<WebElement> forms = driver.findElements(By.tagName("form"));
        WebElement regForm = null;
        for (WebElement element : forms) {
            if (element.getAttribute("data-qaid") != null && element.getAttribute("data-qaid").equals("register_form")) {
                regForm = element;
                break;
            }
        }
        if (regForm == null) {
            LOG.info("Register form was not found!");
            return driver;
        }

        List<WebElement> inputs = regForm.findElements(By.tagName("input"));
        Timer.waitSeconds(4);
        for (WebElement input : inputs) {
            if (input.getAttribute("data-qaid") != null && input.getAttribute("data-qaid").equals("name")) {
                input.sendKeys(account.getFirstName());
            }
            if (input.getAttribute("data-qaid") != null && input.getAttribute("data-qaid").equals("email")) {
                input.sendKeys(account.getEmail());
            }
            if (input.getAttribute("data-qaid") != null && input.getAttribute("data-qaid").equals("password")) {
                input.sendKeys(account.getPassword());
            }
        }

        Timer.waitSeconds(2);
        List<WebElement> buttons = regForm.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            if (button.getAttribute("data-qaid") != null && button.getAttribute("data-qaid").equals("submit")) {
                button.submit();
                break;
            }
        }

        Timer.waitSeconds(10);

        List<WebElement> settingsInputs = regForm.findElements(By.tagName("input"));
        Timer.waitSeconds(4);
        for (WebElement input : settingsInputs) {
            if (input.getAttribute("data-qaid") != null && input.getAttribute("data-qaid").equals("nickname_input")) {
                input.sendKeys(account.getLogin());
            }
            if (input.getAttribute("data-qaid") != null && input.getAttribute("data-qaid").equals("input_field")) {
                input.sendKeys(account.getSecondName());
            }
        }
        Timer.waitSeconds(5);
        List<WebElement> settingsButtons = regForm.findElements(By.tagName("button"));
        for (WebElement button : settingsButtons) {
            if (button.getAttribute("data-qaid") != null && button.getAttribute("data-qaid").equals("save_profile")) {
                button.submit();
                break;
            }
        }

        Timer.waitSeconds(3);
        String currentUrl = driver.getCurrentUrl();
        driver.get(currentUrl);
        Timer.waitSeconds(2);

        return driver;
    }


    public static WebDriver loginAccount(User user, WebDriver driver) {

        driver.get(LOGIN_URL);
        Timer.waitSeconds(3);

        List<WebElement> forms = driver.findElements(By.tagName("page"));
        WebElement logForm = null;
        for (WebElement element : forms) {
            if (element.getAttribute("data-qaid") != null && element.getAttribute("data-qaid").equals("auth-form")) {
                logForm = element;
                break;
            }
        }
        if (logForm == null) {
            LOG.info("Login form was not found!");
            return driver;
        }

        List<WebElement> inputs = logForm.findElements(By.tagName("input"));
        Timer.waitSeconds(4);
        for (WebElement input : inputs) {
            if (input.getAttribute("id") != null && input.getAttribute("id").equals("phone_email")) {
                input.sendKeys(user.getEmail());
            }
        }

        Timer.waitSeconds(5);
        List<WebElement> buttons = logForm.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            if (button.getAttribute("id") != null && button.getAttribute("id").equals("phoneEmailConfirmButton")) {
                button.submit();
                break;
            }
        }

        List<WebElement> secondInputs = logForm.findElements(By.tagName("input"));
        Timer.waitSeconds(4);
        for (WebElement input : secondInputs) {
            if (input.getAttribute("id") != null && input.getAttribute("id").equals("enterPassword")) {
                input.sendKeys(user.getPassword());
            }
        }

        Timer.waitSeconds(5);
        List<WebElement> secondButtons = logForm.findElements(By.tagName("button"));
        for (WebElement button : secondButtons) {
            if (button.getAttribute("id") != null && button.getAttribute("id").
                    equals("enterPasswordConfirmButton")) {
                button.submit();
                break;
            }
        }

        Timer.waitSeconds(5);
        String currentUrl = driver.getCurrentUrl();
        driver.get(currentUrl);
        Timer.waitSeconds(5);

        return driver;
    }
}