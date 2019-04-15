package com.company;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private BasicDataSource dataSource;

    public Database() {

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/prekiu_saugykla?useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setValidationQuery("SELECT 1");
    }

    public void insertGoods(String pavadinimas, String aprasymas, int kiekis, int kaina) {
        String query = "INSERT INTO prekes (pavadinimas, aprasymas, kiekis, kaina)"
                + " VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pavadinimas);
            statement.setString(2, aprasymas);
            statement.setInt(3, kiekis);
            statement.setInt(4, kaina);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
