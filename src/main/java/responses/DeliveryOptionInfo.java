package responses;

import java.util.Map;

public class DeliveryOptionInfo {
  // Variables
  private Integer id;
  private String name;
  private Double price;
  private Integer eta;
  // Constructor
  public DeliveryOptionInfo(Map<String, String> map){
    this.id = Integer.parseInt(map.get("id"));
    this.name = map.get("name");
    this.price = Double.parseDouble(map.get("price"));
    this.eta = Integer.parseInt(map.get("eta"));
  }
  // Getters & Setters
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public Integer getEta() {
    return eta;
  }
  public void setEta(Integer eta) {
    this.eta = eta;
  }
}
