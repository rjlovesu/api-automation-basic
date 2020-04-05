package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class PaymentOptionResponse extends BaseResponse {
  // Variables
  private ArrayList<CardInfo> cardInfos;
  // Methods
  @JsonProperty("data")
  private void unpackData(ArrayList<Map<String, String>> data) {
    cardInfos = new ArrayList<CardInfo>();
    for (Map<String, String> map : data) {
      cardInfos.add(new CardInfo(map));
    }
  }
  public ArrayList<CardInfo> getCardInfos() {
    return cardInfos;
  }
}
