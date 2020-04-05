package payload;

public class OrderDetailsPayload {
  // Variables
  private String paymentId;
  private String addressId;
  private String deliveryMethod;
  // Constructor
  public OrderDetailsPayload(String paymentId, String addressId, String deliveryMethod){
    this.paymentId = paymentId;
    this.addressId = addressId;
    this.deliveryMethod = deliveryMethod;
  }
  // Methods
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
  public String getDeliveryMethod() {
    return deliveryMethod;
  }
  public void setDeliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }
}
