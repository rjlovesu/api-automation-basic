package pages;

import pages.pagesLib.*;

public class PageManager {
    private static RegistrationPage registrationPage = new RegistrationPage();
    private static LoginPage loginPage = new LoginPage();
    private static HomePage homePage = new HomePage();
    private static ResultsPage resultsPage = new ResultsPage();

    public static BasePage getPage(String page){
        switch(page.toLowerCase()){
            case "registration": return registrationPage;
            case "login"       : return loginPage;
            case "home"        : return homePage;
            case "results"     : return resultsPage;
            default            : throw new Error(page + " is undefined");
        }
    }
}
