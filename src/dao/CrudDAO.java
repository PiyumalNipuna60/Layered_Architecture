package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CrudDAO {

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(String id, String name,String address) throws SQLException, ClassNotFoundException;

    public boolean Update(CustomerDTO dto) throws SQLException, ClassNotFoundException;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public boolean Delete(String id) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

}
