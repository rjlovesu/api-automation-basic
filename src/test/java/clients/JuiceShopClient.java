package clients;

import clients.JuiceShopClientLib.RegistrationCalls;

public class JuiceShopClient {
  private RegistrationCalls registrationCalls = new RegistrationCalls();

  public RegistrationCalls getRegistrationCalls(){
    return registrationCalls;
  }
}
