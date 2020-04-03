package clients;

import clients.JuiceShopClientLib.HomeCalls;
import clients.JuiceShopClientLib.LoginCalls;
import clients.JuiceShopClientLib.RegistrationCalls;
import clients.JuiceShopClientLib.ShoppingCalls;

public class JuiceShopClient {
  // Variables
  private RegistrationCalls registrationCalls = new RegistrationCalls();
  private LoginCalls loginCalls = new LoginCalls();
  private HomeCalls homeCalls = new HomeCalls();
  private ShoppingCalls shoppingCalls = new ShoppingCalls();
  // Getters & Setters
  public RegistrationCalls getRegistrationCalls() {
    return registrationCalls;
  }
  public LoginCalls getLoginCalls() {
    return loginCalls;
  }
  public HomeCalls getHomeCalls() {
    return homeCalls;
  }
  public ShoppingCalls getShoppingCalls() {
    return shoppingCalls;
  }
}