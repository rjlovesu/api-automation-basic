package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UserLogInResponse {
  // Variables
  private String Token;
  private Integer bid;
  private String umail;

  // Getters & Setters
  public String getToken() {
    return Token;
  }
  public void setToken(String token) {
    Token = token;
  }
  public Integer getBid() {
    return bid;
  }
  public void setBid(Integer bid) {
    this.bid = bid;
  }
  public String getUmail() {
    return umail;
  }
  public void setUmail(String umail) {
    this.umail = umail;
  }

  @JsonProperty("authentication")
  private void unpackData(Map<String, String> data) {
    setToken(data.get("token"));
    setBid(Integer.parseInt(data.get("bid")));
    setUmail(data.get("umail"));
  }
}
