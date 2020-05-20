package pages.pagesLib;

import responses.AddressResponse;
import responses.BasketContentResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.Map;
import responses.UserLogInResponse;
import org.assertj.core.api.Assertions;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class BasketPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action) {
    switch (capitalizeSecond(action)) {
      case "checkout":
        checkout();
        break;
      case "emptyBasket":
        emptyBasket();
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

  public void emptyBasket(){
    info("Validating whether basket is empty");
    UserLogInResponse userLogInResponse = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    Integer bid = userLogInResponse.getBid();
    ValidatableResponse idResponse = JUICE_SHOP_CLIENT.getRestCalls().getBasket(bid);
    idResponse.statusCode(200);
    BasketContentResponse basketContentResponse = idResponse.extract().body().as(BasketContentResponse.class);
    Assertions.assertThat(basketContentResponse.getBasketContentInfo().isEmpty()).isTrue();
  }

  public void deleteItems(DataTable dataTable) {
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Deleting items with the following data: " + map);
    
    info("Getting basket item ids");
    UserLogInResponse userLogInResponse = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    Integer bid = userLogInResponse.getBid();
    ValidatableResponse idResponse = JUICE_SHOP_CLIENT.getRestCalls().getBasket(bid);
    idResponse.statusCode(200);
    BasketContentResponse basketContentResponse = idResponse.extract().body().as(BasketContentResponse.class);
    ArrayList<Integer> basketItemIds = new ArrayList<Integer>();
    for (String name : map.values()) {
      Integer id = basketContentResponse.getBasketContentInfo().getBasketItemIdByName(name);
      basketItemIds.add(id);
      info(name + " id: " + id);
    }

    info("Sending delete calls");
    for (Integer id : basketItemIds) {
      ValidatableResponse deleteResponse = JUICE_SHOP_CLIENT.getApiCalls().deleteBasketItem(id);
      deleteResponse.statusCode(200);

    }
  }

  public void checkout() {
    info("Performing checkout");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkout();
    response.statusCode(200);
    AddressResponse addressResponse = response.extract().body().as(AddressResponse.class);
    TestCaseContext.getLedger().put("addressResponse", addressResponse);
  }
}
