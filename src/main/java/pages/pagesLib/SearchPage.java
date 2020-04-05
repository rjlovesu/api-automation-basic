package pages.pagesLib;

import io.cucumber.datatable.DataTable;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import java.util.Map;

import helpers.TestCaseContext;
import payload.BasketItemsPayload;
import domain.ProductInfo;
import domain.SearchForResponse;
import domain.UserLogInResponse;

import static helpers.Logger.info;
import static helpers.TestCaseContext.JUICE_SHOP_CLIENT;

public class SearchPage extends BasePage {
  // Methods
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)){
      case "searchResults": searchResults(dataTable); break;
      default             : super.doAction(action, dataTable);
    }
  }
  @Override
  public void doAction(String action, String data) {
    switch (capitalizeSecond(action)){
      case "addToBasket": addToBasket(data); break;
      default           : super.doAction(action, data);
    }
  }
  public void searchResults(DataTable dataTable){
    Map<String, String> map = dataTable.transpose().asMaps().get(0);
    info("Validating Search Results with following data:\n" + map);
    SearchForResponse searchForResponse = (SearchForResponse) TestCaseContext.getLedger().get("searchResponse");
    ProductInfo productInfo =  searchForResponse.getProductInfos().get(0);
    Assertions.assertThat(productInfo.getName()).isEqualTo(map.get("Name"));
    Assertions.assertThat(productInfo.getDescription()).isEqualTo(map.get("Description"));
    Assertions.assertThat(productInfo.getPrice()).isEqualTo(Double.valueOf(map.get("Price")));
  }
  public void addToBasket(String data){
    info("Adding to basket: " + data);
    SearchForResponse searchForResponse = (SearchForResponse) TestCaseContext.getLedger().get("searchResponse");
    if(searchForResponse.getProductInfos().isEmpty()){
      throw new Error("Search results were empty");
    }
    ProductInfo firstProduct = searchForResponse.getProductInfos().get(0);
    UserLogInResponse user = (UserLogInResponse)TestCaseContext.getLedger().get("loggedInUser");
    if(firstProduct.getName().equals(data)){
      BasketItemsPayload basketItemsPayload =
              new BasketItemsPayload(firstProduct.getId(), user.getBid().toString(), 1);
      ValidatableResponse response =
              JUICE_SHOP_CLIENT.getApiCalls().addToBasket(basketItemsPayload);
      response.statusCode(200);
    }else {
      throw new Error("Given item name " + data + " not found in the search response");
    }
  }
}
