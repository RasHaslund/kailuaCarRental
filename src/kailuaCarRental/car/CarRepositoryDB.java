package kailuaCarRental.car;

import kailuaCarRental.database.DataBaseConnector;
import kailuaCarRental.model.Car;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRepositoryDB implements CarRepository {

    @Override
    public List<Car> findAll() {

        String sql = "SELECT Car_ID, Category_ID, Brand, Model, LicensPlate, FuelType, " +
                "Odometer, First_Registration_date FROM Car ORDER BY Car_ID";

        List<Car> carList = new ArrayList<>();

        try (Connection con = DataBaseConnector.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) carList.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("CarRepositoryDB.findAll fejl: " + e.getMessage());
        }
        return carList;
    }

    @Override
    public Optional<Car> findById(int carId) {

        String sql = "SELECT Car_ID, Category_ID, Brand, Model, LicensPlate, FuelType, " +
                "Odometer, First_Registration_date FROM Car WHERE Car_LicensPlate=?";

        try (Connection con = DataBaseConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return Optional.of(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("CarRepositoryDB.findById fejl: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public int insert(Car c) {

        String sql = "INSERT INTO Car (Category_ID, Brand, Model, LicensPlate, FuelType, " +
                "Odometer, First_Registration_date) VALUES (?,?,?,?,?,?,?)";

        try (Connection con = DataBaseConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, c.getCategoryId());
            ps.setString(2, c.getBrand());
            ps.setString(3, c.getModel());
            ps.setString(4, c.getLicensPlate());
            ps.setString(5, c.getFuelType());
            ps.setInt(6, c.getOdometer());
            ps.setDate(7, Date.valueOf(c.getFirstRegistrationDate()));

            int affected = ps.executeUpdate();
            if (affected == 1) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("CarRepositoryDB.insert fejl: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean update(Car c) {

        String sql = "UPDATE Car SET Category_ID=?, Brand=?, Model=?, LicensPlate=?, FuelType=?, " +
                "Odometer=?, First_Registration_date=? WHERE Car_ID=?";
        try (Connection con = DataBaseConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, c.getCategoryId());
            ps.setString(2, c.getBrand());
            ps.setString(3, c.getModel());
            ps.setString(4, c.getLicensPlate());
            ps.setString(5, c.getFuelType());
            ps.setInt(6, c.getOdometer());
            ps.setDate(7, Date.valueOf(c.getFirstRegistrationDate()));
            ps.setInt(8, c.getCarId());

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("CarRepositoryDB.update fejl: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int carId) {

        String sql = "DELETE FROM Car WHERE Car_ID=?";
        try (Connection con = DataBaseConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("CarRepositoryDB.delete fejl: " + e.getMessage());
            return false;
        }
    }

    // --- helper ---
    private Car mapRow(ResultSet rs) throws SQLException {

        Car c = new Car();
        c.setCarId(rs.getInt("Car_ID"));
        c.setCategoryId(rs.getInt("Category_ID"));
        c.setBrand(rs.getString("Brand"));
        c.setModel(rs.getString("Model"));
        c.setLicensPlate(rs.getString("LicensPlate"));
        c.setFuelType(rs.getString("FuelType"));
        c.setOdometer(rs.getInt("Odometer"));
        Date d = rs.getDate("First_Registration_date");
        c.setFirstRegistrationDate(d != null ? d.toLocalDate() : LocalDate.now());

        return c;
    }
}
