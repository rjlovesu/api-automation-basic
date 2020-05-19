package pages.pagesLib;

import responses.AddressResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;
import io.cucumber.datatable.DataTable;
import java.util.Map;

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
    switch (action){
      case "deleteItems": deleteItems(); break;
      default           : super.doAction(action);
    }
  }

  public void deleteItems(){
    info("Deleting items");
    
  }

  public void checkout(){
    info("Performing checkout");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkout();
    response.statusCode(200);
    AddressResponse addressResponse = response.extract().body().as(AddressResponse.class);
    TestCaseContext.getLedger().put("addressResponse", addressResponse);
  }
}
