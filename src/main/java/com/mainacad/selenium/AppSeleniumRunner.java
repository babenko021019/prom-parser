package com.mainacad.selenium;

import com.mainacad.selenium.driver.WebDriverFactory;
import com.mainacad.selenium.model.Account;
import com.mainacad.selenium.model.User;
import com.mainacad.selenium.service.PromAccountService;
import com.mainacad.util.Timer;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class AppSeleniumRunner {

    private static final Logger LOG = Logger.getLogger(AppSeleniumRunner.class.getName());

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getChromedriver();

        Timer.waitSeconds(10);

        Account account = new Account
                ("Alex45687", "1234567890", "Alex", "Han",
                        "alex33345687@ukr.net");

        driver = PromAccountService.registerAccount(account, driver);
        Timer.waitSeconds(10);

        driver.quit();


        WebDriver secondDriver = WebDriverFactory.getChromedriver();

        Timer.waitSeconds(5);

        User user = new User(account.getEmail(), account.getPassword());

        secondDriver = PromAccountService.loginAccount(user, secondDriver);

        Timer.waitSeconds(5);

        secondDriver.quit();
    }
}
