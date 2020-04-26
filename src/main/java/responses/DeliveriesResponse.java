package responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class DeliveriesResponse extends BaseResponse {
  // Variables
  private ArrayList<DeliveryOptionInfo> deliveryOptionInfos;
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, String>> data) {
    deliveryOptionInfos = new ArrayList<DeliveryOptionInfo>();
    for (Map<String, String> map : data) {
      deliveryOptionInfos.add(new DeliveryOptionInfo(map));
    }
  }
  public ArrayList<DeliveryOptionInfo> getDeliveryOptionInfos() {
    return deliveryOptionInfos;
  }
}
