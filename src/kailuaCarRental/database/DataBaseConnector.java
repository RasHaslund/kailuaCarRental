package kailuaCarRental.database;

import java.sql.*;

public class DataBaseConnector {



    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Kailua_CarRental";


    private static final String USER = "root";
    private static final String PASS = "Kodeord";

    private DataBaseConnector() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASS);
    }


}





// _________________________________________________________________________________

/** TEST FORBINDELSE */

//    public static void main(String[] args) {
//
//        try {
//            Connection con = DriverManager.getConnection(DATABASE_URL, "root", "JegCyklerMegetTilMysql8487r!");
//            Statement s = con.createStatement();
//            ResultSet rs = s.executeQuery("SELECT * FROM Car");
//
//            while (rs.next()) {
//                int id = rs.getInt("Car_ID");
//                String brand = rs.getString("Brand");
//                String model = rs.getString("Model");
//                String plate = rs.getString("LicensPlate");
//                String fuel = rs.getString("FuelType");
//
//                System.out.println(id + " | " + brand + " | " + model + " | " + plate + " | " + fuel);
//            }
//
//            // 3) Luk ressourcer (senere med try-with-resources)
//            rs.close();
//            s.close();
//            con.close();
//
//            System.out.println("Forbindelse lykkedes!");
//        } catch (SQLException e) {
//            System.out.println("Fejl i forbindelse: " + e.getMessage());
//        }
//
//
//    }



