package stepdefinitions;

import cucumber.api.java.en.When;
import helpers.ActionManager;
import helpers.PageLib.BasicActions;

import java.lang.reflect.InvocationTargetException;

public class validationSteps {
  @When("{string} should be {string}")
  public void idoSomethingWithSomething(String object, String action) {
    throw new Error("STEP UNDEFINDD");
    //ActionManager.getObject(object).getClass().getMethod(action).invoke(BasicActions.class);
  }
}
