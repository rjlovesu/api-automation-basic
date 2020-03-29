package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyInfo {
  @JsonProperty(value = "vat_number")
  private String vatNumber;
  private String name;
  @JsonProperty(value = "registration_number")
  private String registrationNumber;
  private String address;

  public String getVatNumber() {
    return vatNumber;
  }

  public String getName() {
    return name;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setVatNumber(String vatNumber) {
    this.vatNumber = vatNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
