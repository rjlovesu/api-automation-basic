package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationPayload extends Payload {
  // Variables
  private String email;
  private String password;
  private String passwordRepeat;
  @JsonProperty(value = "securityQuestion")
  private SecurityQuestionPayload securityQuestionPayload;
  private String securityAnswer;
  // Constructor
  public UserRegistrationPayload(String email, String password, SecurityQuestionPayload securityQuestionPayload, String securityAnswer) {
    this.email = email;
    this.password = password;
    this.passwordRepeat = password;
    this.securityQuestionPayload = securityQuestionPayload;
    this.securityAnswer = securityAnswer;
  }
  // Getters & Setters
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPasswordRepeat() {
    return passwordRepeat;
  }
  public void setPasswordRepeat(String passwordRepeat) {
    this.passwordRepeat = passwordRepeat;
  }
  public SecurityQuestionPayload getSecurityQuestionPayload() {
    return securityQuestionPayload;
  }
  public void setSecurityQuestionPayload(SecurityQuestionPayload securityQuestionPayload) {
    this.securityQuestionPayload = securityQuestionPayload;
  }
  public String getSecurityAnswer() {
    return securityAnswer;
  }
  public void setSecurityAnswer(String securityAnswer) {
    this.securityAnswer = securityAnswer;
  }
}
