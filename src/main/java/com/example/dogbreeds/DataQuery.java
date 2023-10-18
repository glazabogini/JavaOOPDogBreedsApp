package com.example.dogbreeds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataQuery {
    public static List<DogBreed> getDogBreeds() {
        DatabaseConnector dbConnector = new DatabaseConnector();
        List<DogBreed> breeds = new ArrayList<>();

        try (Connection connection = dbConnector.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Breeds");

            while (resultSet.next()) {
                DogBreed breed = new DogBreed(
                        resultSet.getInt("ID"),
                        resultSet.getString("BreedName"),
                        resultSet.getString("Origin"),
                        resultSet.getString("Size"),
                        resultSet.getInt("NumberOfOwners")
                );
                breeds.add(breed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return breeds;
    }
}

