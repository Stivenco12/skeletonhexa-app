package com.ferreteriapp.infrastructure.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.ferreteriapp.domain.Repositoy.EpsRepository;
import com.ferreteriapp.domain.entities.eps;
import com.ferreteriapp.infrastructure.database.ConnectionDb;

public class EpsRepositoryImlp implements EpsRepository {
    private final ConnectionDb connectionDb;
    public EpsRepositoryImlp(ConnectionDb connectionDb){
        this.connectionDb = connectionDb;
    }
    @Override
    public void save(eps eps) {
        String sqlInsert = "INSERT INTO eps (name) VALUES (?)";
        try(Connection conn = connectionDb.getConexion();
            PreparedStatement ps = conn.prepareStatement(sqlInsert)){ 
            ps.setString(1, eps.getName());
            ps.executeUpdate();
            System.out.println("los datos an sido enviados con exito");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public eps findById(int id) {
        String sqlSelect = "SELECT name FROM eps WHERE id = ?";
        try (Connection conn = connectionDb.getConexion();
        PreparedStatement ps = conn.prepareStatement(sqlSelect)){
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new eps(rs.getInt(id),rs.getString("name"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<eps> fiadAll() {
        List<eps> epsList = new ArrayList<>();
        String sqlSelect = "SELECT id, name FROM eps";
        try (Connection conn = connectionDb.getConexion();
        PreparedStatement ps = conn.prepareStatement(sqlSelect)){
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            epsList.add(new eps(rs.getInt("id"), rs.getNString("name")));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(eps eps) {
        String sql = "UPDATE eps SET name = ? WHERE id = ?";
        try (Connection conn = connectionDb.getConexion();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, eps.getName());
            ps.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = connectionDb.getConexion();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("producto elimnado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
