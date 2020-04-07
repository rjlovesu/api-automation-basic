package pages.pagesLib;

import domain.AddressInfo;
import domain.AddressResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class AddressPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, String data) {
    switch (capitalizeSecond(action)){
      case "chooseDeliveryAddress": chooseDeliveryAddress(data); break;
      default             : super.doAction(action, data);
    }
  }
  public void chooseDeliveryAddress(String address){
    info("Choosing delivery address: " + address);
    AddressResponse addressResponse = (AddressResponse) TestCaseContext.getLedger().get("addressResponse");
    for (AddressInfo info : addressResponse.getAddressInfos()) {
      if (info.getStreetAddress().equals(address)){
        ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkAddress(info.getId());
        response.statusCode(200);
        TestCaseContext.getLedger().put("addressId", info.getId());
        return;
      }
    }
    throw new Error("Did not find " + address + " in address response");
  }
}
