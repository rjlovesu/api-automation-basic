package pages.pagesLib;

import domain.SearchForResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class HomePage extends BasePage {
  @Override
  public void doAction(String action, String str) {
    switch (capitalizeSecond(action)){
      case "searchFor": searchFor(str); break;
      default         : super.doAction(action, str);
    }
  }
  public void searchFor(String str){
    info("Searching for: " + str);
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().searchFor(str);
    response.statusCode(200);
    SearchForResponse searchForResponse = response.extract().body().as(SearchForResponse.class);
    TestCaseContext.getLedger().put("searchResponse", searchForResponse);
  }
}
