package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class UserLogInResponse extends BaseResponse {
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
    setToken(data.get("token"));
    setBid(Integer.parseInt(data.get("bid")));
    setUmail(data.get("umail"));
  }
}
