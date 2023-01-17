package dao.custom.Impl;

import dao.SqlUtil;
import dao.custom.QueryDAO;
import model.CustomDTO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomDTO> searchOrderByOrderId(String id) throws SQLException, ClassNotFoundException {
        String sql="select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?";
        ResultSet rst = SqlUtil.executeQuery(sql, id);

        ArrayList<CustomDTO> orderRecord=new ArrayList<>();
        while (rst.next()){
            String oid = rst.getString(1);
            String date = rst.getString(2);
            String customerID = rst.getString(3);
            String itemCode = rst.getString(4);
            int qty = rst.getInt(5);
            BigDecimal unitPrice = rst.getBigDecimal(6);

            CustomDTO customDTO = new CustomDTO();
            customDTO.setOid(oid);
            customDTO.setOrderDate(LocalDate.parse(date));
            customDTO.setCustomerId(customerID);
            customDTO.setItemCode(itemCode);
            customDTO.setQty(qty);
            customDTO.setUnitPrice(unitPrice);
            orderRecord.add(customDTO);
        }
        return orderRecord;
    }
}
