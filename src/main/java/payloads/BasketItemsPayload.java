package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketItemsPayload extends Payload {
  // Variables
  @JsonProperty(value = "ProductId")
  private Integer productId;
  @JsonProperty(value = "BasketId")
  private String basketId;
  private Integer quantity;
  // Constructor
  public BasketItemsPayload(Integer productId, String basketId, Integer quantity) {
    this.productId = productId;
    this.basketId = basketId;
    this.quantity = quantity;
  }
  // Getters & Setters
  public Integer getProductId() {
    return productId;
  }
  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  public String getBasketId() {
    return basketId;
  }
  public void setBasketId(String basketId) {
    this.basketId = basketId;
  }
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
