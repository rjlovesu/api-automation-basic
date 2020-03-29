package clients.JuiceShopClientLib;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import payload.UserRegistrationPayload;

public class RegistrationCalls extends BaseCalls {
  // Variables
  private static final String API_USERS = "api/Users/";
  //  Methods
  public static ValidatableResponse createUser(UserRegistrationPayload payload){
    return  (ValidatableResponse) RestAssured.
            given().
            log().ifValidationFails().
            contentType(ContentType.JSON).
            body(payload).
            when().
            post(BASE_PAGE + API_USERS).
            then().
            log().ifValidationFails();
  }
}
