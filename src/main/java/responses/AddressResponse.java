package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class AddressResponse extends BaseResponse {
  // Variables
  private ArrayList<AddressInfo> addressInfos;
  // Getter & setters
  public ArrayList<AddressInfo> getAddressInfos() {
    return addressInfos;
  }
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, String>> data) {
    addressInfos = new ArrayList<AddressInfo>();
    for (Map<String, String> map : data) {
      addressInfos.add(new AddressInfo(map));
    }
  }
}
