package clients.JuiceShopClientLib;

import io.restassured.response.ValidatableResponse;

import payload.UserLogInPayload;

public class LoginCalls extends BaseCalls {
  // Variables
  private static final String REST_USER_LOGIN = "rest/user/login";
  // Methods
  public ValidatableResponse logIn(UserLogInPayload payload){
    return post(REST_USER_LOGIN, payload);
  }
}
