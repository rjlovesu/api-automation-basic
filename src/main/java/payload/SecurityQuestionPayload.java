package payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;

public class SecurityQuestionPayload  extends Payload{
  // Variables
  Integer id;
  String question;
  String createdAt;
  String updatedAt;
  @JsonIgnore
  HashMap<String, Integer> securityQuestions;
  // Constructor
  public SecurityQuestionPayload(String question){
    initSecurityQuestions();
    this.id = securityQuestions.get(question);
    this.question = question;
    this.createdAt = java.time.Clock.systemUTC().instant().toString();
    this.updatedAt = java.time.Clock.systemUTC().instant().toString();
  }
  // Getters & Setters
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getQuestion() {
    return question;
  }
  public void setQuestion(String question) {
    this.question = question;
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
  public HashMap<String, Integer> getSecurityQuestions() {
    return securityQuestions;
  }
  public void setSecurityQuestions(HashMap<String, Integer> securityQuestions) {
    this.securityQuestions = securityQuestions;
  }
  // Methods
  private void initSecurityQuestions(){
    securityQuestions = new HashMap<String, Integer>();
    securityQuestions.put("Your eldest siblings middle name?", 1);
    securityQuestions.put("Mother's maiden name?", 2);
    securityQuestions.put("Mother's birth date? (MM/DD/YY)", 3);
    securityQuestions.put("Father's birth date? (MM/DD/YY)", 4);
    securityQuestions.put("Maternal grandmother's first name?", 5);
    securityQuestions.put("Paternal grandmother's first name?", 6);
    securityQuestions.put("Name of your favorite pet?", 7);
    securityQuestions.put("Last name of dentist when you were a teenager? (Do not include 'Dr.')", 8);
    securityQuestions.put("Your ZIP/postal code when you were a teenager?", 9);
    securityQuestions.put("Company you first work for as an adult?", 10);
    securityQuestions.put("Your favorite book?", 11);
    securityQuestions.put("Your favorite movie?", 12);
    securityQuestions.put("Number of one of your customer or ID cards?", 13);
  }
}
