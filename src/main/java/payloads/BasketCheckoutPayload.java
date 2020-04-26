package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketCheckoutPayload extends Payload {
  // Variables
  private String couponData;
  @JsonProperty("orderDetails")
  private OrderDetailsPayload orderDetails;
  // Constructor
  public BasketCheckoutPayload(String couponData, OrderDetailsPayload orderDetailsPayload){
    this.couponData = couponData;
    this.orderDetails = orderDetailsPayload;
  }
  // Getters & Setters
  public String getCouponData() {
    return couponData;
  }
  public void setCouponData(String couponData) {
    this.couponData = couponData;
  }
  public OrderDetailsPayload getOrderDetails() {
    return orderDetails;
  }
  public void setOrderDetails(OrderDetailsPayload orderDetails) {
    this.orderDetails = orderDetails;
  }
}
