package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageManager;
import io.cucumber.datatable.DataTable;

public class actionSteps {
  @When("I {string} in {string} page with the following data:")
  public void i_in_page_with_the_following_data(String action, String page, DataTable dataTable) {
    PageManager.getPage(page).doAction(action, dataTable);
  }

  @When("I search for {string}")
  public void i_search_for(String str) {
    PageManager.getPage("Home").doAction("search for", str);
  }

  @Then("I log in with the following data:")
  public void i_log_in_with_the_following_data(DataTable dataTable) {
    PageManager.getPage("Login").doAction("log in", dataTable);
  }
}
