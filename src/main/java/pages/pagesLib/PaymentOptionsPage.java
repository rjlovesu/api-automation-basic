package pages.pagesLib;

import responses.CardInfo;
import responses.PaymentOptionResponse;
import helpers.TestCaseContext;
import io.restassured.response.ValidatableResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class PaymentOptionsPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action) {
    // Methods
    switch (capitalizeSecond(action)){
      case "getPaymentOptions": getPaymentOptions(); break;
      default                   : super.doAction(action);
    }
  }
  @Override
  public void doAction(String action, String data) {
    switch (capitalizeSecond(action)){
      case "choosePaymentOption": choosePaymentOption(data); break;
      default                   : super.doAction(action, data);
    }
  }
  public void getPaymentOptions(){
    info("Getting payment options");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().getCards();
    response.statusCode(200);
    PaymentOptionResponse paymentOptionResponse = response.extract().body().as(PaymentOptionResponse.class);
    TestCaseContext.getLedger().put("paymentOptionResponse", paymentOptionResponse);
  }
  public void choosePaymentOption(String cardNumber){
    info("Choosing payment option: " + cardNumber);
    PaymentOptionResponse paymentOptionResponse =
            (PaymentOptionResponse) TestCaseContext.getLedger().get("paymentOptionResponse");
    for (CardInfo info : paymentOptionResponse.getCardInfos()) {
      if(info.getCardNumber().equals(cardNumber)){
        ValidatableResponse response = JUICE_SHOP_CLIENT.getApiCalls().checkCard(info.getId());
        response.statusCode(200);
        TestCaseContext.getLedger().put("paymentId", info.getId());
        return;
      }
    }
    throw new Error("Did not find " + cardNumber + " in payment options response");
  }
}
