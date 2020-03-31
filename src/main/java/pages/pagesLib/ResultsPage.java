package pages.pagesLib;

import domain.ProductInfo;
import domain.SearchForResponse;
import helpers.TestCaseContext;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.Assertions;

import java.util.Map;

import static helpers.Logger.info;

public class ResultsPage extends BasePage {

  @Override
  public void doAction(String action, DataTable dataTable) {
    switch (capitalizeSecond(action)){
      case "searchResults": searchResults(dataTable); break;
      default             : super.doAction(action, dataTable);
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
}
