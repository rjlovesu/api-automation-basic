package responses;

import java.util.ArrayList;
import java.util.Map;



public class BasketContentInfo{
  private ArrayList<Map<String, Object>> products;

  public BasketContentInfo(Map<String, Object> data){
    products = (ArrayList<Map<String, Object>>)data.get("Products");
    
  }

  public String getBasketItemIdByName(String name){
    for(Map<String, Object> product: products){
      if(product.get("name").equals(name)){
        @SuppressWarnings("unchecked")
        Map<String,String> basketItemInfo=(Map<String,String>)product.get("BasketItem");
        return basketItemInfo.get("id");
      }
    }
    return "id not found";
  }

  public ArrayList<Map<String, Object>> getProducts(){
    return products;
  }

  public void setProducts(ArrayList<Map<String, Object>> products){
    this.products=products;
  }
  // Methods
}
