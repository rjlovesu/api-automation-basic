package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class CardInfo {
  // Variables
  private Integer id;
  private String fullName;
  private String cardNumber;
  private Integer expMonth;
  private Integer expYear;
  private String createdAt;
  private String updatedAt;
  @JsonProperty("UserId")
  private Integer userId;
  // Constructor
  public CardInfo(Map<String, String> map) {
    this.id = Integer.parseInt(map.get("id"));
    this.fullName = map.get("fullName");
    this.cardNumber = map.get("cardNum");
    this.expMonth = Integer.parseInt(map.get("expMonth"));
    this.expYear = Integer.parseInt(map.get("expYear"));
    this.createdAt = map.get("createdAt");
    this.updatedAt = map.get("updatedAt");
    this.userId = Integer.parseInt(map.get("UserId"));
  }
  // Methods
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getCardNumber() {
    return cardNumber;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public Integer getExpMonth() {
    return expMonth;
  }
  public void setExpMonth(Integer expMonth) {
    this.expMonth = expMonth;
  }
  public Integer getExpYear() {
    return expYear;
  }
  public void setExpYear(Integer expYear) {
    this.expYear = expYear;
  }
  public String getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  public String getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
