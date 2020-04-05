package pages.pagesLib;

import io.restassured.response.ValidatableResponse;

import domain.DeliveriesResponse;
import domain.DeliveryOptionInfo;
import helpers.TestCaseContext;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class DeliveryOptionsPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, String data) {
    switch (capitalizeSecond(action)){
      case "chooseDeliveryOption": chooseDeliveryOption(data); break;
      default                    : super.doAction(action, data);
    }
  }
  @Override
  public void doAction(String action) {
    switch (capitalizeSecond(action)){
      case "getDeliveryOptions": getDeliveryOptions(); break;
      default                  : super.doAction(action);
    }
  }
  public void chooseDeliveryOption(String option){
    info("Choosing delivery option: " + option);
    DeliveriesResponse deliveriesResponse =
            (DeliveriesResponse) TestCaseContext.getLedger().get("deliveriesResponse");
    for (DeliveryOptionInfo info : deliveriesResponse.getDeliveryOptionInfos()) {
      if(info.getName().equals(option)){
        ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkDelivery(info.getId());
        response.statusCode(200);
        TestCaseContext.getLedger().put("deliveryMethodId", info.getId());
        return;
      }
    }
    throw new Error("Did not find " + option + " in deliveries response");
  }
  public void getDeliveryOptions(){
    info("Getting delivery options");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().getDeliveries();
    response.statusCode(200);
    DeliveriesResponse deliveriesResponse = response.extract().body().as(DeliveriesResponse.class);
    TestCaseContext.getLedger().put("deliveriesResponse", deliveriesResponse);
  }
}
