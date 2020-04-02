package pages;

import pages.pagesLib.*;

public class PageManager {
    // Variables
    private static RegistrationPage registrationPage = new RegistrationPage();
    private static LoginPage loginPage = new LoginPage();
    private static HomePage homePage = new HomePage();
    private static SearchResultsPage searchResultsPage = new SearchResultsPage();
    // Methods
    public static BasePage getPage(String page){
        switch(page.toLowerCase()){
            case "registration"  : return registrationPage;
            case "login"         : return loginPage;
            case "home"          : return homePage;
            case "search results": return searchResultsPage;
            default              : throw new Error(page + " is undefined");
        }
    }
}
