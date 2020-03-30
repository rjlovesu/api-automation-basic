package clients.JuiceShopClientLib;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import payload.Payload;

public class BaseCalls {
  // Variables
  public static final String BASE_PAGE = "http://localhost:3000/";
  // Methods
  public ValidatableResponse post(String post, Payload payload){
    return  (ValidatableResponse) RestAssured.
            given().
            log().ifValidationFails().
            contentType(ContentType.JSON).
            body(payload).
            when().
            post(BASE_PAGE + post).
            then().
            log().ifValidationFails();
  }
}
