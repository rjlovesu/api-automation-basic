package actions;

import actions.Pages.BasePage;
import actions.Pages.LoginPage;
import actions.Pages.RegistrationPage;

public class ActionManager {
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
