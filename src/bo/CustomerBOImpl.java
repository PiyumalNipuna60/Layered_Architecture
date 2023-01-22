package bo;

import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

}
