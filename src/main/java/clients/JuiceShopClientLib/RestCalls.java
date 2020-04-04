package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payload.UserLogInPayload;

public class RestCalls extends BaseCalls {
  // Variables
  private static final String REST_USER_LOGIN = "rest/user/login";
  private static final String REST_PRODUCTS_SEARCH = "rest/products/search?q=";
  // Methods
  public ValidatableResponse logIn(UserLogInPayload payload){
    return post(REST_USER_LOGIN, payload);
  }
  public ValidatableResponse searchFor(String str){
    return get(REST_PRODUCTS_SEARCH + str);
  }
}
