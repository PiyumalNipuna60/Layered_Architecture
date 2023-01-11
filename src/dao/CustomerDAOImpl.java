package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
