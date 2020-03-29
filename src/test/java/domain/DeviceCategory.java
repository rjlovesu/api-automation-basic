package domain;

import java.util.List;

public class DeviceCategory {
  private Integer id;
  private String name;
  private String os;
  private String type;
  private List<Device> devices;

  public void DeviceCategory(){

  }

  public void setDevices(List<Device> devices) {
    this.devices = devices;
  }

  public List<Device> getDevices() {
    return devices;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getOs() {
    return os;
  }

  public String getType() {
    return type;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public void setType(String type) {
    this.type = type;
  }
}
