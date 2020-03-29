package domain;

public class ProjectDevice {
  private Integer id;
  private String price;
  private Device Device;

  public ProjectDevice() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public domain.Device getDevice() {
    return Device;
  }

  public void setDevice(domain.Device device) {
    Device = device;
  }
}
