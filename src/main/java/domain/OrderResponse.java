package domain;

public class OrderResponse extends BaseResponse {
  // Variables
  private String orderConfirmation;
  // Methods
  public String getOrderConfirmation() {
    return orderConfirmation;
  }
  public void setOrderConfirmation(String orderConfirmation) {
    this.orderConfirmation = orderConfirmation;
  }
}
