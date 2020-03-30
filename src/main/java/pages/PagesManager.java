package pages;

import pages.pagesLib.BasePage;
import pages.pagesLib.LoginPage;
import pages.pagesLib.RegistrationPage;

public class PagesManager {
    private static RegistrationPage registrationPage = new RegistrationPage();
    private static LoginPage loginPage = new LoginPage();


    public static BasePage getPage(String page){
        switch(page.toLowerCase()){
            case "registration": return registrationPage;
            case "login"       : return loginPage;
            default            : throw new Error(page + " is undefined");
        }
    }
}
