package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;

public class BasketContentResponse extends BaseResponse {
  // Variables
  private BasketContentInfo basketContentInfo;
  // Methods
  @JsonProperty("data")
  private void unpackData(Map<String, Object> data) {
    this.basketContentInfo = new BasketContentInfo(data);
  }
  
  public BasketContentInfo getBasketContentInfo(){
    return basketContentInfo;
  }
  public void setBasketContentInfo(BasketContentInfo basketContentInfo){
    this.basketContentInfo=basketContentInfo;
  }

}
