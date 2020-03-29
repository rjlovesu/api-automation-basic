package helpers;

import clients.JuiceShopClient;
import java.util.HashMap;

public class TestCaseContext {
    public final static JuiceShopClient JUICE_SHOP_CLIENT = new JuiceShopClient();
    public static HashMap<String, Object> ledger = new HashMap<String, Object>();
}
