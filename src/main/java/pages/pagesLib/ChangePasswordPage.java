package pages.pagesLib;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class ChangePasswordPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)) {
      case "changePassword":
        changePassword(dataTable);
        break;
      default:
        super.doAction(action, dataTable);
    }
  }

  public void changePassword(DataTable dataTable) {

    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Changing password with the following data: " + map);

    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().changePassword(
        map.get("Current Password"),
        map.get("New Password"), 
        map.get("Repeat New Password"));
    response.statusCode(200);
    
  }
}
