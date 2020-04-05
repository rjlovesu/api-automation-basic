package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payload.BasketCheckoutPayload;
import payload.UserLogInPayload;

import java.security.PublicKey;

public class RestCalls extends BaseCalls {
  // Variables
  private static final String REST_USER_LOGIN = "rest/user/login";
  private static final String REST_PRODUCTS_SEARCH = "rest/products/search?q=";
  private static final String REST_BASKET_ = "rest/basket/";
  private static final String _CHECKOUT = "/checkout";

  // Methods
  public ValidatableResponse logIn(UserLogInPayload payload){
    return post(REST_USER_LOGIN, payload);
  }
  public ValidatableResponse searchFor(String str){
    return get(REST_PRODUCTS_SEARCH + str);
  }
  public ValidatableResponse checkoutBasket(Integer bid, BasketCheckoutPayload payload){
    return post(REST_BASKET_ + bid + _CHECKOUT, payload);
  }
}
