package dao.custom.Impl;

import dao.custom.ItemDAO;
import dao.SqlUtil;
import model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ResultSet rst = SqlUtil.executeQuery("SELECT * FROM Item");


        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            allItem.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)

            ));
        }
        return allItem;
    }

    public boolean Delete(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeUpdate()>0;

        return SqlUtil.executeUpdate("DELETE FROM Item WHERE code=?", code);
    }

    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, dto.getCode());
//        pstm.setString(2, dto.getDescription());
//        pstm.setBigDecimal(3, dto.getUnitPrice());
//        pstm.setInt(4, dto.getQtyOnHand());
//        return pstm.executeUpdate()>0;

        return SqlUtil.executeUpdate("INSERT INTO Item (code, description, qtyOnHand, unitPrice) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice());
    }

    public boolean Update(ItemDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setString(1, dto.getDescription());
//        pstm.setBigDecimal(2, dto.getUnitPrice());
//        pstm.setInt(3, dto.getQtyOnHand());
//        pstm.setString(4, dto.getCode());
//        return pstm.executeUpdate()>0;

        return SqlUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public ItemDTO Search(String s) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
//        pstm.setString(1, newValue + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();

        ResultSet rst = SqlUtil.executeQuery("SELECT * FROM Item WHERE code=?", s);
        if (rst.next()) {
            return new ItemDTO(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getBigDecimal(4));
        }
        return null;
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();

        ResultSet rst = SqlUtil.executeQuery("SELECT code FROM Item WHERE code=?", code);
        return rst.next();
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        ResultSet rst = SqlUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
