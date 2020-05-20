package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payloads.BasketCheckoutPayload;
import payloads.UserLogInPayload;

public class RestCalls extends BaseCalls {
  // Variables
  private static final String REST_USER_LOGIN = "rest/user/login";
  private static final String REST_PRODUCTS_SEARCH = "rest/products/search?q=";
  private static final String REST_BASKET_ = "rest/basket/";
  private static final String _CHECKOUT = "/checkout";
  private static final String REST_TRACK_ORDER = "rest/track-order/";
  private static final String REST_USER_CHANGE_PASSWORD = "rest/user/change-password";
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
  public ValidatableResponse getTrackOrder(String orderId){
    return get(REST_TRACK_ORDER + orderId);
  }
  public ValidatableResponse getBasket(Integer bid){
    return get(REST_BASKET_ + bid);
  }
  public ValidatableResponse changePassword(String oldPassword,String newPassword,String newPasswordRepeat){
    //rest/user/change-password?current=demo&new=newpw&repeat=newpw
    return get(REST_USER_CHANGE_PASSWORD + "?current="+oldPassword+"&new="+newPassword+"&repeat="+newPasswordRepeat);
  }
}
