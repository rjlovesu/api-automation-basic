package pages.pagesLib;

import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

import domain.UserLogInResponse;
import helpers.TestCaseContext;
import payload.UserLogInPayload;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class LoginPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch(action){
      case "log in": logIn(dataTable); break;
      default      : super.doAction(action, dataTable);
    }
  }
  public void logIn(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Logging in with the following data:\n" + map);
    String email = map.get("Email");
    String password = map.get("Password");
    UserLogInPayload userLogInPayload = new UserLogInPayload(email, password);
    ValidatableResponse response = JUICE_SHOP_CLIENT.getLoginCalls().logIn(userLogInPayload);
    response.statusCode(200);
    UserLogInResponse userLogInResponse = response.extract().body().as(UserLogInResponse.class);
    TestCaseContext.getLedger().put("loggedInUser", userLogInResponse);
  }
}
