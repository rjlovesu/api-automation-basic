package pages.pagesLib;

import domain.ProductInfo;
import domain.TrackOrderResponse;
import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import java.util.ArrayList;
import java.util.Map;
import domain.OrderResponse;
import domain.UserLogInResponse;
import helpers.TestCaseContext;
import org.assertj.core.api.Assertions;
import payload.BasketCheckoutPayload;
import payload.OrderDetailsPayload;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class OrderCompletionPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action) {
    switch (capitalizeSecond(action)) {
      case "checkoutOrder": checkoutOrder(); break;
      default:  super.doAction(action);
    }
  }
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)){
      case "trackOrder": trackOrder(dataTable); break;
      default          : super.doAction(action, dataTable);
    }
  }
  public void checkoutOrder(){
    info("Checking out order");
    String paymentId = TestCaseContext.getLedger().get("paymentId").toString();
    String addressId = TestCaseContext.getLedger().get("addressId").toString();
    String deliveryMethodId = TestCaseContext.getLedger().get("deliveryMethodId").toString();
    UserLogInResponse userLogInResponse = (UserLogInResponse) TestCaseContext.getLedger().get("loggedInUser");
    Integer bid = userLogInResponse.getBid();
    OrderDetailsPayload payload =
            new OrderDetailsPayload(paymentId, addressId, deliveryMethodId);
    BasketCheckoutPayload basketCheckoutPayload = new BasketCheckoutPayload("", payload);
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().checkoutBasket(bid, basketCheckoutPayload);
    response.statusCode(200);
    OrderResponse orderResponse = response.extract().body().as(OrderResponse.class);
    TestCaseContext.getLedger().put("orderId", orderResponse.getOrderConfirmation());
  }
  public void trackOrder(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Tracking order with the following data:\n" + map);
    String orderId = (String) TestCaseContext.getLedger().get("orderId");
    ValidatableResponse response = JUICE_SHOP_CLIENT.getRestCalls().getTrackOrder(orderId);
    response.statusCode(200);
    TrackOrderResponse trackOrderResponse = response.extract().body().as(TrackOrderResponse.class);
    ArrayList<ProductInfo> products = trackOrderResponse.getTrackOrderInfo().getProducts();
    for (ProductInfo productInfo : products) {
      if(productInfo.getName().contains(map.get("Name"))){
        Assertions.assertThat(productInfo.getName()).isEqualTo(map.get("Name"));
        Assertions.assertThat(productInfo.getPrice().toString()).isEqualTo(map.get("Price"));
        Assertions.assertThat(trackOrderResponse.getTrackOrderInfo().getDelivered().toString()).isEqualTo(map.get("Delivered"));
        return;
      }
    }
    info("Did not find product with name: " + map.get("Name"));
    Assertions.assertThat(false).isEqualTo(true);
  }
}
