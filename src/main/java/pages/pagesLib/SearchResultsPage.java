package pages.pagesLib;

import domain.ProductInfo;
import domain.SearchForResponse;
import domain.UserLogInResponse;
import helpers.TestCaseContext;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.Assertions;
import payload.BasketItemsPayload;

import java.util.Map;

import static helpers.Logger.info;

public class SearchResultsPage extends BasePage {
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
    SearchForResponse searchForResponse = (SearchForResponse) TestCaseContext.getLedger().get("Search Response");
    ProductInfo productInfo =  searchForResponse.getProductInfos().get(0);
    Assertions.assertThat(productInfo.getName()).isEqualTo(map.get("Name"));
    Assertions.assertThat(productInfo.getDescription()).isEqualTo(map.get("Description"));
    Assertions.assertThat(productInfo.getPrice()).isEqualTo(Double.valueOf(map.get("Price")));
  }
  public void addToBasket(String data){
    info("Adding to basket: " + data);
    SearchForResponse searchForResponse = (SearchForResponse) TestCaseContext.getLedger().get("searchResponse");
    ProductInfo firstProduct = searchForResponse.getProductInfos().get(0);
    UserLogInResponse user = (UserLogInResponse)TestCaseContext.getLedger().get("loggedInUser");
    if(firstProduct.getName().equals(data)){
      info(firstProduct.getId() + " ");
      BasketItemsPayload basketItemsPayload =
              new BasketItemsPayload(firstProduct.getId(), user.getBid().toString(), 1);

    }else {
      throw new Error("Given item name " + data + " not found in the search response");
    }
  }
}
