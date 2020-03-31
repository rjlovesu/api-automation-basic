package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class SearchForResponse {
  // Variables
  private String status;
  private ArrayList<ProductInfo> productInfos;
  // Getters and Setters
  public ArrayList<ProductInfo> getProductInfos() {
    return productInfos;
  }
  public void setProductInfos(ArrayList<ProductInfo> productInfos) {
    this.productInfos = productInfos;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, String>> data) {
    productInfos = new ArrayList<ProductInfo>();
    for (Map<String, String> map : data) {
      Integer id = Integer.parseInt(map.get("id"));
      String name = map.get("name");
      String description = map.get("description");
      Double price = Double.parseDouble(map.get("price"));
      Double deluxePrice = Double.parseDouble(map.get("deluxePrice"));
      String image = map.get("image");
      String createdAt = map.get("createdAt");
      String updatedAt = map.get("updatedAt");
      String deletedAt = map.get("deletedAt");
      productInfos.add(new ProductInfo(id, name, description, price, deluxePrice, image, createdAt, updatedAt, deletedAt));
    }
    System.out.println("????????");
    System.out.println(productInfos.get(0).getCreatedAt());

    // setToken(data.get("token"));
    // setBid(Integer.parseInt(data.get("bid")));
    // setUmail(data.get("umail"));
  }
}
