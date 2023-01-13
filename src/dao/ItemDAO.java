package dao;

import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    public boolean DeleteItem(String code) throws SQLException, ClassNotFoundException;

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

}
