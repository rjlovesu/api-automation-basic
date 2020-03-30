package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import helpers.TestCaseContext;
import static java.lang.Thread.sleep;

public class Hooks {
  Process juiceShopProcess;
  ProcessBuilder processBuilder = new ProcessBuilder();
  public static TestCaseContext TEST_CASE_CONTEXT;

  @Before
  public void setUp(){
    killJuiceShop();
    startJuiceShop();

    //System.out.println("Before hook!");
    // TEST_CASE_CONTEXT = new TestCaseContext();
  }

  @After
  public void cleanUp(){
    clearJuiceShop();

    /*
    System.out.println("After hook!");
    User user = (User) TEST_CASE_CONTEXT.ledger.get("user");
    if(user!=null){
      System.out.println("Deleting user: " + user.getId());
      String password = (String) TEST_CASE_CONTEXT.ledger.get("password");
      DeleteUserPayload deleteUserPayload = new DeleteUserPayload(password);
      ValidatableResponse response = TEST_FORTY_EIGHT_CLIENT.getAccountCalls().deleteAnAccount(deleteUserPayload, user);
      Integer code =  response.extract().statusCode();
      // 204 if it is being deleted; 404 if it has been already deleted;
      Assertions.assertThat(code == 204 || code == 404).isEqualTo(true);
    }
    */
  }

  // Juice Shop methods
  private void startJuiceShop(){
    // Clearing node's just in case any is running in the background.
    killJuiceShop();
    try {
      juiceShopProcess = processBuilder.command("bash", "-c", "cd ../juice-shop ; npm start").start();
      BufferedReader br = new BufferedReader(new InputStreamReader(juiceShopProcess.getInputStream()));
      String line = "";
      while((line = br.readLine()) != null) {
        System.out.println(line);
        if(line.contains("Server listening on port 3000")){ return; }
        if(line.toLowerCase().contains("warn")){ throw new Error("Failed to set up Juice Shop"); }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void clearJuiceShop(){
    killJuiceShop();
    for(int i = 0; i < 25; i++){
      if(juiceShopProcess.isAlive()){
        try {
          sleep(400);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }else {
        return;
      }
    }
    throw new Error("Failed to kill node server");
  }
  private void killJuiceShop(){
    try {
      processBuilder.command("bash", "-c", "killall -9 node").start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
