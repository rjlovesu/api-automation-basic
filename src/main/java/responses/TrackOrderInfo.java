package responses;

import java.util.ArrayList;
import java.util.Map;

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
  private Integer deliveryPrice;
  private String eta;
  private String _id;
  private ArrayList<ProductInfo> products;
  // Constructor
  public TrackOrderInfo(ArrayList<Map<String, Object>> data){
    Map<String, Object> map = data.get(0);
    this.promotionalAmount = (Integer) map.get("promotionalAmount");
    this.paymentId = (String) map.get("paymentId");
    this.addressId = (String) map.get("addressId");
    this.orderId  = (String) map.get("orderId");
    this.delivered = (Boolean) map.get("delivered");
    this.email = (String) map.get("email");
    this.totalPrice = (Double) map.get("totalPrice");
    this.bonus = (Integer) map.get("bonus");
    this.deliveryPrice = (Integer) map.get("deliveryPrice");
    this.eta = (String) map.get("eta");
    this._id = (String) map.get("_id");
    unpackData((ArrayList<Map<String, Object>>) map.get("products"));
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
  public Integer getDeliveryPrice() {
    return deliveryPrice;
  }
  public void setDeliveryPrice(Integer deliveryPrice) {
    this.deliveryPrice = deliveryPrice;
  }
  public String getEta() {
    return eta;
  }
  public void setEta(String eta) {
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
  private void unpackData(ArrayList<Map<String, Object>> data) {
    products = new ArrayList<ProductInfo>();
    for (Map<String, Object> map : data) {
      products.add(new ProductInfo(map));
    }
  }
}
