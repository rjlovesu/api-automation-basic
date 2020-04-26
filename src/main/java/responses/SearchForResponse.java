package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class SearchForResponse extends BaseResponse {
  // Variables
  private ArrayList<ProductInfo> productInfos;
  // Getters and Setters
  public ArrayList<ProductInfo> getProductInfos() {
    return productInfos;
  }
  public void setProductInfos(ArrayList<ProductInfo> productInfos) {
    this.productInfos = productInfos;
  }
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, Object>> data) {
    productInfos = new ArrayList<ProductInfo>();
    for (Map<String, Object> map : data) {
      productInfos.add(new ProductInfo(map));
    }
  }
}
