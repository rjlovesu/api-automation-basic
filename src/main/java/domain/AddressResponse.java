package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class AddressResponse {
  // Variables
  private String status;
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
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
}
