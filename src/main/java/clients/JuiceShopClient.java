package clients;

import clients.JuiceShopClientLib.ApiCalls;
import clients.JuiceShopClientLib.RestCalls;

public class JuiceShopClient {
  // Variables
  private ApiCalls apiCalls = new ApiCalls();
  private RestCalls restCalls = new RestCalls();

  // Getters & Setters
  public ApiCalls getApiCalls() {
    return apiCalls;
  }
  public RestCalls getRestCalls() {
    return restCalls;
  }
}
