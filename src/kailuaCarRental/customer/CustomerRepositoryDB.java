package kailuaCarRental.customer;

import kailuaCarRental.database.DataBaseConnector;
import kailuaCarRental.model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryDB implements CustomerRepository {

    @Override
    public boolean delete(int customerId) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer findByID(int customerId) {
        return null;
    }

    @Override
    public int insert(Customer customer) {

        String sql = "INSERT INTO Customer (Customer_ID, Name, Address, Zip, City, Phone, Email) VALUES (?,?,?,?,?,?,?)";

        try (Connection con = DataBaseConnector.getConnection();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getZip());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getEmail());

            int affected = ps.executeUpdate();
            if (affected == 1) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) return keys.getInt(1);
                }
            }

        } catch (SQLException e) {
            System.out.println("CustomerRepositoryDB.insert fajl: " + e.getMessage());
        } return -1;
    }


    @Override
    public List<Customer> findAll() {

        String sql = "SELECT Customer_ID, Name, Address, Zip, City, Phone, Email FROM Customer ORDER BY Customer_ID";

        List<Customer> customerList = new ArrayList<>();

        try (Connection con = DataBaseConnector.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) customerList.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("CustomerRepositoryDB.findAll fejl: " + e.getMessage());

        }
            return customerList;
        }



    private Customer mapRow(ResultSet rs) throws SQLException {

        Customer c = new Customer();
        c.setCustomerId(rs.getInt("Customer_ID"));
        c.setName(rs.getString("Name"));
        c.setAddress(rs.getString("Address"));
        c.setZip(rs.getString("Zip"));
        c.setCity(rs.getString("City"));
        c.setPhone(rs.getString("Phone"));
        c.setEmail(rs.getString("Email"));

        return c;
    }
}
