package responses;

import java.util.Map;

public class AddressInfo {
  // Variables
  private Integer id;
  private String fullName;
  private String mobileNum;
  private String zipCode;
  private String streetAddress;
  private String city;
  private String state;
  private String country;
  private String createdAt;
  private String updatedAt;
  private Integer userId;
  // Constructor
  public AddressInfo(Map<String, String> map){
    this.id = Integer.parseInt(map.get("id"));
    this.fullName = map.get("fullName");
    this.mobileNum = map.get("mobileNum");
    this.zipCode = map.get("zipCode");
    this.streetAddress = map.get("streetAddress");
    this.city = map.get("city");
    this.state = map.get("state");
    this.country = map.get("country");
    this.createdAt = map.get("createdAt");
    this.updatedAt = map.get("updatedAt");
    this.userId = Integer.parseInt(map.get("UserId"));
  }
  // Getters & Setters
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
  public String getMobileNum() {
    return mobileNum;
  }
  public void setMobileNum(String mobileNum) {
    this.mobileNum = mobileNum;
  }
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public String getStreetAddress() {
    return streetAddress;
  }
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
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
