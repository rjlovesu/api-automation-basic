package pages;

import pages.pagesLib.BasePage;
import pages.pagesLib.HomePage;
import pages.pagesLib.LoginPage;
import pages.pagesLib.RegistrationPage;

public class PageManager {
    private static RegistrationPage registrationPage = new RegistrationPage();
    private static LoginPage loginPage = new LoginPage();
    private static HomePage homePage = new HomePage();

    public static BasePage getPage(String page){
        switch(page.toLowerCase()){
            case "registration": return registrationPage;
            case "login"       : return loginPage;
            case "home"        : return homePage;
            default            : throw new Error(page + " is undefined");
        }
    }
}
