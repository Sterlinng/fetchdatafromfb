package org.acme.services.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import org.acme.dtos.NameListDTO;
import org.acme.services.FetchDataService;

import javax.sql.DataSource;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FetchDataServiceImpl implements FetchDataService {

    @Inject
    DataSource dataSource;

    
    @Override
    public List<NameListDTO> getAllData() {
        List<NameListDTO> data = new ArrayList<>();
    
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT name FROM personnes";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    NameListDTO dto = new NameListDTO();
                    dto.setName(name); 
                    data.add(dto); 
                }
            }
        } catch (Exception e) {
            throw new Error("Erreur lors de la récupération des données.", e);
        }
    
        return data;
    }    
}
