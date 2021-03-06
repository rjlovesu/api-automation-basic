package responses;

import java.util.ArrayList;
import java.util.Map;



public class BasketContentInfo{
  private ArrayList<Map<String, Object>> products;

  public BasketContentInfo(Map<String, Object> data){
    products = (ArrayList<Map<String, Object>>)data.get("Products");
    
  }

  public boolean isEmpty(){
    return products.size()==0;
  }

  public Integer getBasketItemIdByName(String name){
    for(Map<String, Object> product: products){
      if(product.get("name").equals(name)){
        @SuppressWarnings("unchecked")
        Map<String,Object> basketItemInfo=(Map<String,Object>)product.get("BasketItem");
        return (Integer)basketItemInfo.get("id");
      }
    }
    return null;
  }

  public ArrayList<Map<String, Object>> getProducts(){
    return products;
  }

  public void setProducts(ArrayList<Map<String, Object>> products){
    this.products=products;
  }
  // Methods
}
