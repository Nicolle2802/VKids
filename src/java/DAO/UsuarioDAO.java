/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioDAO {
    
public boolean validarCredenciales(Usuario usuario) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Si hay al menos uno, credenciales correctas
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Credenciales inválidas o error
    }
}