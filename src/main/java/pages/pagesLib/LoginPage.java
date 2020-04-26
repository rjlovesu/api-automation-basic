package pages.pagesLib;

import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import java.util.Map;

import responses.UserLogInResponse;
import helpers.TestCaseContext;
import payloads.UserLogInPayload;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class LoginPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch(action){
      case "log in": logIn(dataTable); break;
      case "try to log in": tryToLogIn(dataTable); break;
      case "response code": responseCode(dataTable); break;
      default      : super.doAction(action, dataTable);
    }
  }
  public void logIn(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Logging in with the following data:\n" + map);
    String email = map.get("Email");
    String password = map.get("Password");
    UserLogInPayload userLogInPayload = new UserLogInPayload(email, password);
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().logIn(userLogInPayload);
    response.statusCode(200);
    UserLogInResponse userLogInResponse = response.extract().body().as(UserLogInResponse.class);
    TestCaseContext.getLedger().put("loggedInUser", userLogInResponse);
  }

  public void tryToLogIn(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Logging in with the following data:\n" + map);
    String email = map.get("Email");
    String password = map.get("Password");
    UserLogInPayload userLogInPayload = new UserLogInPayload(email, password);
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().logIn(userLogInPayload);
    TestCaseContext.getLedger().put("tryToLogIn", response);
  }

  public void responseCode(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Validating response code:\n" + map);
    ValidatableResponse response = (ValidatableResponse) TestCaseContext.getLedger().get("tryToLogIn");

    if(map.get("Response code") != null){
      response.statusCode(Integer.parseInt(map.get("Response code")));
    }

    if(map.get("Error message") != null){
      String errorMessage = map.get("Error message");
      String responseMessage =  response.extract().body().asString();

      Assertions.assertThat(errorMessage.equals(responseMessage)).isTrue();
    }
  }
}
