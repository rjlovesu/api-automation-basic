package helpers.PageLib;

import domain.User;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import payload.SecurityQuestionPayload;
import payload.UserRegistrationPayload;

import java.util.List;
import java.util.Map;
import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class RegistrationPage extends BasePage {
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)){
      case "createUser": createUser(dataTable); break;
      default          : super.doAction(action, dataTable);
    }
  }

  public void createUser(DataTable dataTable){
    List<Map<String,String>> data = dataTable.transpose().asMaps();
    Map map = data.get(0);
    info("Creating user with the following data: " + map);
    String email = map.get("Email").toString();
    String password = map.get("Password").toString();
    String securityAnswer = map.get("Security answer").toString();
    String securityQuestion = map.get("Security question").toString();
    SecurityQuestionPayload securityQuestionPayload = new SecurityQuestionPayload(securityQuestion);
    UserRegistrationPayload userRegistrationPayload =
            new UserRegistrationPayload(email, password, securityQuestionPayload, securityAnswer);

    ValidatableResponse response =
            JUICE_SHOP_CLIENT.getRegistrationCalls().createUser(userRegistrationPayload);
    response.statusCode(201);
    info(response.toString());
    User user = response.extract().body().as(User.class);
    info("Created user: " + user.getId());
  }
}
