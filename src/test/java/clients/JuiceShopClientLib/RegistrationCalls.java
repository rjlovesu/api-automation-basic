package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;
import payload.UserRegistrationPayload;

public class RegistrationCalls extends BaseCalls {
  // Variables
  private static final String API_USERS_ = "api/Users/";
  //  Methods
  public ValidatableResponse createUser(UserRegistrationPayload payload){
    return post(API_USERS_, payload);
  }
}
