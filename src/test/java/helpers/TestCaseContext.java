package helpers;

import clients.JuiceShopClient;
import java.util.HashMap;

public class TestCaseContext {
  // Variables
  public static HashMap<String, Object> ledger = new HashMap<String, Object>();
  public final static JuiceShopClient JUICE_SHOP_CLIENT = new JuiceShopClient();
  // Getters & Setters
  public static HashMap<String, Object> getLedger(){
    return ledger;
  }
}
