package clients;

import clients.JuiceShopClientLib.RegistrationCalls;

public class JuiceShopClient {
  private static RegistrationCalls registrationCalls = new RegistrationCalls();

  public RegistrationCalls getRegistrationCalls(){
    return registrationCalls;
  }
}
