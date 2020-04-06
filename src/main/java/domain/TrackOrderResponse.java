package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class TrackOrderResponse extends BaseResponse {
  private TrackOrderInfo trackOrderInfo;

  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, Object>> data) {
    TrackOrderInfo trackOrderInfo = new TrackOrderInfo(data);
  }
  public TrackOrderInfo getTrackOrderInfo() {
    return trackOrderInfo;
  }
  public void setTrackOrderInfo(TrackOrderInfo trackOrderInfo) {
    this.trackOrderInfo = trackOrderInfo;
  }
}
