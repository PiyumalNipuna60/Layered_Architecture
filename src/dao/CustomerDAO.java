package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(String id, String name,String address) throws SQLException, ClassNotFoundException;

    public boolean UpdateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;


    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

}
