package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class UserRegistrationResponse {
  // Variables
  @JsonProperty(value = "status")
  private String status;
  private String username;
  private String role;
  private String lastLoginIp;
  private String profileImage;
  private String isActive;
  private Integer id;
  private String email;
  private String updatedAt;
  private String createdAt;
  private String deletedAt;
  // Getters & Setters
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public String getLastLoginIp() {
    return lastLoginIp;
  }
  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }
  public String getProfileImage() {
    return profileImage;
  }
  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }
  public String getIsActive() {
    return isActive;
  }
  public void setIsActive(String isActive) {
    this.isActive = isActive;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
  public String getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  public String getDeletedAt() {
    return deletedAt;
  }
  public void setDeletedAt(String deletedAt) {
    this.deletedAt = deletedAt;
  }
  @JsonProperty("data")
  private void unpackData(Map<String, String> data) {
    setUsername((data.get("username")));
    setRole((data.get("role")));
    setLastLoginIp((data.get("lastLoginIp")));
    setProfileImage((data.get("profileImage")));
    setIsActive((data.get("isActive")));
    setId(Integer.parseInt(data.get("id")));
    setEmail(data.get("email"));
    setCreatedAt(data.get("updatedAt"));
    setCreatedAt(data.get("createdAt"));
    setCreatedAt(data.get("deletedAt"));
  }
}
