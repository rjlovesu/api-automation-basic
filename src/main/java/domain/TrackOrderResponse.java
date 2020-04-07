package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class TrackOrderResponse extends BaseResponse {
  // Variables
  private TrackOrderInfo trackOrderInfo;
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, Object>> data) {
    this.trackOrderInfo = new TrackOrderInfo(data);
  }
  // Getters & Setters
  public TrackOrderInfo getTrackOrderInfo() {
    return trackOrderInfo;
  }
  public void setTrackOrderInfo(TrackOrderInfo trackOrderInfo) {
    this.trackOrderInfo = trackOrderInfo;
  }
}
