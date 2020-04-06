package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

import static helpers.Logger.info;

public class TrackOrderInfo {
  // Variables
  private Integer promotionalAmount;
  private String paymentId;
  private String addressId;
  private String orderId;
  private Boolean delivered;
  private String email;
  private Double totalPrice;
  private Integer bonus;
  private Double deliveryPrice;
  private Integer eta;
  private String _id;
  private ArrayList<ProductInfo> products;
  // Constructor
  public TrackOrderInfo(ArrayList<Map<String, Object>> data){

  }
  // Getters & Setters
  public Integer getPromotionalAmount() {
    return promotionalAmount;
  }
  public void setPromotionalAmount(Integer promotionalAmount) {
    this.promotionalAmount = promotionalAmount;
  }
  public String getPaymentId() {
    return paymentId;
  }
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }
  public String getAddressId() {
    return addressId;
  }
  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }
  public String getOrderId() {
    return orderId;
  }
  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }
  public Boolean getDelivered() {
    return delivered;
  }
  public void setDelivered(Boolean delivered) {
    this.delivered = delivered;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Double getTotalPrice() {
    return totalPrice;
  }
  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }
  public Integer getBonus() {
    return bonus;
  }
  public void setBonus(Integer bonus) {
    this.bonus = bonus;
  }
  public Double getDeliveryPrice() {
    return deliveryPrice;
  }
  public void setDeliveryPrice(Double deliveryPrice) {
    this.deliveryPrice = deliveryPrice;
  }
  public Integer getEta() {
    return eta;
  }
  public void setEta(Integer eta) {
    this.eta = eta;
  }
  public String get_id() {
    return _id;
  }
  public void set_id(String _id) {
    this._id = _id;
  }
  public ArrayList<ProductInfo> getProducts() {
    return products;
  }
  public void setProducts(ArrayList<ProductInfo> products) {
    this.products = products;
  }
  // Methods
  @JsonProperty("products")
  private void unpackData(ArrayList<Map<String, String>> data) {
    products = new ArrayList<ProductInfo>();
    for (Map<String, String> map : data) {
      products.add(new ProductInfo(map));
    }
  }
}
