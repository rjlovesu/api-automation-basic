package pages.pagesLib;

import responses.AddressResponse;
import responses.BasketContentResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Map;
import responses.UserLogInResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class BasketPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action) {
    switch (action) {
      case "checkout":
        checkout();
        break;
      default:
        super.doAction(action);
    }
  }

  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)) {
      case "deleteItems":
        deleteItems(dataTable);
        break;
      default:
        super.doAction(action);
    }
  }

  public void deleteItems(DataTable dataTable) {

    Map<String, String> map = dataTable.transpose().asMaps().get(0);

    info("DELETING ITEMS WITH THE FOLLOWING DATA: " + map);
    

    info("Getting user bid");
    UserLogInResponse userLogInResponse = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    Integer bid = userLogInResponse.getBid();


    info("Getting basket item ids");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().getBasket(bid);
    info(response.extract().response().asString());

    BasketContentResponse basketContentResponse = response.extract().body().as(BasketContentResponse.class);
    ArrayList<Integer> basketItemIds=new ArrayList<Integer>();
    for(String name: map.values()){
      Integer id = basketContentResponse.getBasketContentInfo().getBasketItemIdByName(name);
      basketItemIds.add(id);
      info(name+" id: "+id);
    }


    info("Sending delete calls");
    for(Integer id: basketItemIds){
      JUICE_SHOP_CLIENT.getApiCalls().deleteBasketItem(id);
    }
  }

  public void checkout(){
    info("Performing checkout");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkout();
    response.statusCode(200);
    AddressResponse addressResponse = response.extract().body().as(AddressResponse.class);
    TestCaseContext.getLedger().put("addressResponse", addressResponse);
  }
}
