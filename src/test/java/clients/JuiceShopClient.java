package clients;

import clients.JuiceShopClientLib.LoginCalls;
import clients.JuiceShopClientLib.RegistrationCalls;

public class JuiceShopClient {
  // Variables
  private RegistrationCalls registrationCalls = new RegistrationCalls();
  private LoginCalls loginCalls = new LoginCalls();
  // Getters & Setters
  public RegistrationCalls getRegistrationCalls(){
    return registrationCalls;
  }
  public LoginCalls getLoginCalls() {
    return loginCalls;
  }
}
