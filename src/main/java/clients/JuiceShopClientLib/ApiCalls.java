package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;

import payload.BasketItemsPayload;
import payload.UserRegistrationPayload;

public class ApiCalls extends BaseCalls {
  // Variables
  private static final String API_USERS_ = "api/Users/";
  private static final String API_ADDRESS =  "api/Addresss";
  private static final String API_BASKET_ITEMS = "api/BasketItems/";
  //  Methods
  public ValidatableResponse createUser(UserRegistrationPayload payload){
    return post(API_USERS_, payload);
  }
  public ValidatableResponse addToBasket(BasketItemsPayload payload){
    return post(API_BASKET_ITEMS, payload);
  }
  public ValidatableResponse checkout(){
    return get(API_ADDRESS);
  }
}
