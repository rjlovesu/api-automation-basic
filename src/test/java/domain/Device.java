package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
  private Integer id;
  private String model;
  private String name;
  @JsonProperty(value = "os_version")
  private String osVersion;
  private String price;
  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void Device(){

  }

  public Integer getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public String getName() {
    return name;
  }

  public String getOsVersion() {
    return osVersion;
  }

  public String getPrice() {
    return price;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
