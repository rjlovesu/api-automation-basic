package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payload.Payload;

public class HomeCalls extends BaseCalls {
  // Variables
  private static final String REST_PRODUCTS_SEARCH = "rest/products/search?q=";
  // Methods
  public ValidatableResponse searchFor(String str){
    return get(REST_PRODUCTS_SEARCH + str);
  }
}
