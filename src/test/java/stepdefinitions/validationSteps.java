package stepdefinitions;

import cucumber.api.java.en.Then;
import actions.ActionManager;
import io.cucumber.datatable.DataTable;

public class validationSteps {
  @Then("I log in with the following data:")
  public void i_log_in_with_the_following_data(DataTable dataTable) {
    ActionManager.getPage("login").doAction("log in", dataTable);
  }
}
