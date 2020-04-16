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
        if(line.contains("listening")){ return; }
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
