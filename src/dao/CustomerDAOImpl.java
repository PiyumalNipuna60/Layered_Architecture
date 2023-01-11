package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> AllCustomer=new ArrayList<>();

        while (rst.next()){
            AllCustomer.add(new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return AllCustomer;
    }

    public void saveCustomer(String id, String name,String address) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, id);
        pstm.setString(2, name);
        pstm.setString(3, address);
        pstm.executeUpdate();
    }
}
