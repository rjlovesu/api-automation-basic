package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class UserLogInResponse {
  // Variables
  private String token;
  private Integer bid;
  private String umail;
  // Getters & Setters
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
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
    this.token = data.get("token");
    this.bid = Integer.parseInt(data.get("bid"));
    this.umail = data.get("umail");
  }
}
