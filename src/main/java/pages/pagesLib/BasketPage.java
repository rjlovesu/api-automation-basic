package pages.pagesLib;

import responses.AddressResponse;
import responses.BasketContentResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;
import io.cucumber.datatable.DataTable;
import java.util.Map;
import responses.UserLogInResponse;
import helpers.TestCaseContext;
import io.cucumber.datatable.DataTable;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class BasketPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action) {
    switch (action){
      case "checkout": checkout(); break;
      default        : super.doAction(action);
    }
  }

  @Override
  public void doAction(String action,DataTable datatable) {
    switch (capitalizeSecond(action)){
      case "deleteItems": deleteItems(datatable); break;
      default           : super.doAction(action);
    }
  }

  public void deleteItems(DataTable datatable){
    info("DELETING ITEMS");
    info("Getting user bid");
    UserLogInResponse userLogInResponse = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    Integer bid = userLogInResponse.getBid();
    
    info("Getting basket");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().getBasket(bid);
    info(response.extract().body());

    BasketContentResponse basketContentResponse = response.extract().body().as(BasketContentResponse.class);
  }

  public void checkout(){
    info("Performing checkout");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkout();
    response.statusCode(200);
    AddressResponse addressResponse = response.extract().body().as(AddressResponse.class);
    TestCaseContext.getLedger().put("addressResponse", addressResponse);
  }
}
