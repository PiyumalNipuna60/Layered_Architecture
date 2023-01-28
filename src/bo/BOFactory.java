package bo;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuoerBO getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITem:
                return new ItemBOImpl();
            case purchase_order:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BOType {
        CUSTOMER, ITem, purchase_order
    }

}
