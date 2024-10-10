package com.example.bioproject.repository;

import com.example.bioproject.model.Kiosk;
import com.example.bioproject.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KioskRepository {
    private List<Kiosk> kioskList;
    private String JDBC_USERNAME = "root";
    private String JDBC_DATABASE_URL = "jdbc:mysql://localhost:3306/kea";
    private String JDBC_PASSWORD = "Emperiusvalor1!";

    public KioskRepository(){
        kioskList = new ArrayList<>();
    }

    public List<Kiosk> getKioskList(){
        return kioskList;
    }

    public void createKioskItem(Kiosk newKioskItem) {
        try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            // Prepare the SQL statement with RETURN_GENERATED_KEYS
            String sql = "INSERT INTO kiosk (kioskName, kioskPrice)"
                    +
                    "VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement
            ps.setString(1, newKioskItem.getName());
            ps.setDouble(2, newKioskItem.getPrice());

            // Execute the update
            ps.executeUpdate();

            // Retrieve the generated keys (movieID)
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int kioskID = generatedKeys.getInt(1); // Get the generated movieID
                newKioskItem.setID(kioskID); // Set it on the newMovie object
            }

            // Add the movie to the movie list
            kioskList.add(newKioskItem);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateKiosk(int id, Kiosk updatedKiosk) {

        Kiosk kioskToUpdate = new Kiosk();

        for (Kiosk kiosk : kioskList) {
            if (kiosk.getID() == id) {
                kiosk.setID(id);
                kiosk.setName(updatedKiosk.getName());
                kiosk.setPrice(updatedKiosk.getPrice());
                kioskToUpdate = kiosk;
                break;
            }
        }

        if (kioskToUpdate != null) {
            // Database operation for updating
            try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE kiosk SET kioskName = ?, kioskPrice = ?");
                ps.setString(1, kioskToUpdate.getName());
                ps.setDouble(2, kioskToUpdate.getPrice());
                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteKiosk(int ID) {
        Kiosk removeKiosk = null;

        for (Kiosk kiosk : kioskList) {
            if (kiosk.getID() == ID) {
                removeKiosk = kiosk;

                try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM kiosk WHERE kioskID = ?");
                    ps.setInt(1, ID);
                    ps.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            }
        }

        if (removeKiosk != null) {
            kioskList.remove(removeKiosk);
        }
    }
}
