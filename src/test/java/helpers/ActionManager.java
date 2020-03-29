package helpers;

import helpers.PageLib.*;

public class ActionManager {
    private static RegistrationPage registrationPage = new RegistrationPage();


    public static BasePage getPage(String page){
        switch(page.toLowerCase()){
            case "registration": return registrationPage;
            default            : throw new Error(page + " is undefined");
        }
    }
}
