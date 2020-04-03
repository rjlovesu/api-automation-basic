package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payload.BasketItemsPayload;

public class ShoppingCalls extends BaseCalls {
  // Variables
  private static final String API_BASKET_ITEMS = "api/BasketItems/";
  // Methods
  public ValidatableResponse addToBasket(String token, BasketItemsPayload payload){
    return post(token, API_BASKET_ITEMS, payload);
  }
}
