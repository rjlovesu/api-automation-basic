package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class BasketContentResponse extends BaseResponse {
  // Variables
  //private TrackOrderInfo trackOrderInfo;
  // Methods
  @JsonProperty("data")
  private void unpackData(Map<String, Object> data) {
    //this.trackOrderInfo = new TrackOrderInfo(data);
  }
  
}
