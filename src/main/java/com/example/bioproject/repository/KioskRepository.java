package com.example.bioproject.repository;

import com.example.bioproject.model.Kiosk;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KioskRepository {
    private List<Kiosk> kioskList;
    private String JDBC_USERNAME = "root";
    private String JDBC_DATABASE_URL = "jdbc:mysql://localhost:3306/kea";
    private String JDBC_PASSWORD = "27SlimHuskies";

    public KioskRepository() {
        kioskList = new ArrayList<>();
    }

    public void insertKioskToKioskList() {
        try (Connection connection = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM kiosk");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Kiosk kiosk = new Kiosk();
                kiosk.setID(resultSet.getInt("kioskID"));
                kiosk.setName(resultSet.getString("kioskName"));
                kiosk.setPrice(resultSet.getDouble("kioskPrice"));
                kioskList.add(kiosk);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Kiosk> getKioskList() {
        if (kioskList.isEmpty()) {
            insertKioskToKioskList();
        }
        return kioskList;
    }

    public Kiosk getKioskByID(int ID) {
        for (Kiosk kiosk : kioskList) {
            if (kiosk.getID() == ID) {
                return kiosk;
            }
        }
        return null;
    }

    public void createKioskItem(Kiosk newKioskItem) {
        try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "INSERT INTO kiosk (kioskName, kioskPrice)"
                    +
                    "VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, newKioskItem.getName());
            ps.setDouble(2, newKioskItem.getPrice());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int kioskID = generatedKeys.getInt(1);
            }

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
            try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE kiosk SET kioskName = ?, kioskPrice = ? WHERE kioskID = ?");
                ps.setString(1, kioskToUpdate.getName());
                ps.setDouble(2, kioskToUpdate.getPrice());
                ps.setInt(3, id);
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
