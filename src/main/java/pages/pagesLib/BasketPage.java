package pages.pagesLib;

import domain.SearchForResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class BasketPage extends BasePage {
  @Override
  public void doAction(String action) {
    switch (action){
      case "checkout": checkout(); break;
      default        : super.doAction(action);
    }
  }

  public void checkout(){
    info("Performing checkout");
    //ValidatableResponse response = JUICE_SHOP_CLIENT.getBasket
    //response.statusCode(200);
    //SearchForResponse searchForResponse = response.extract().body().as(SearchForResponse.class);
    //TestCaseContext.getLedger().put("searchResponse", searchForResponse);
  }
}
