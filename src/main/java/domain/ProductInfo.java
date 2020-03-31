package domain;

public class ProductInfo {
  // Variables
  private Integer id;
  private String name;
  private String description;
  private Double price;
  private Double deluxePrice;
  private String image;
  private String createdAt;
  private String updatedAt;
  private String deletedAt;
  // Constructor
  public ProductInfo(Integer id, String name, String description, Double price, Double deluxePrice, String image, String createdAt, String updatedAt, String deletedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.deluxePrice = deluxePrice;
    this.image = image;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
  // Getters & Setters
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public Double getDeluxePrice() {
    return deluxePrice;
  }
  public void setDeluxePrice(Double deluxePrice) {
    this.deluxePrice = deluxePrice;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
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
  public String getDeletedAt() {
    return deletedAt;
  }
  public void setDeletedAt(String deletedAt) {
    this.deletedAt = deletedAt;
  }
}
