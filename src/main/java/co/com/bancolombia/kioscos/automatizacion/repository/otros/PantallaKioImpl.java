package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import co.com.bancolombia.kioscos.automatizacion.modelos.PantallaTextKio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PantallaKioImpl implements Repositorio<PantallaTextKio> {
    private Connection getConnection() throws SQLException {
        return ConnectionBaseDatos.getInstance();
    }
    @Override
    public List listar() {
        return null;
    }

    @Override
    public PantallaTextKio porId(Long id) {
        PantallaTextKio pantallaTextKio = new PantallaTextKio(id);
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM pantallas_text WHERE id_pantalla =?")){
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                pantallaTextKio.setText(rs.getString("text_pantalla"));
            }else {pantallaTextKio = null;}
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pantallaTextKio;
    }

    @Override
    public void guardar(PantallaTextKio pantallaTextKio) {
        String sql1 = "INSERT INTO pantallas_text(id_pantalla, text_pantalla) VALUES(?,?)";
        String sql2 = "UPDATE pantallas_text SET text_pantalla=? WHERE id_pantalla=?";
        String sql3 = "SELECT id_pantalla FROM pantallas_text WHERE id_pantalla = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql3)){
            stmt.setLong(1, pantallaTextKio.getId());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                try (PreparedStatement stmtUpdate = getConnection().prepareStatement(sql2)){
                    stmtUpdate.setLong(2,pantallaTextKio.getId());
                    stmtUpdate.setString(1,pantallaTextKio.getText());
                    stmtUpdate.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                try (PreparedStatement stmtUpdate = getConnection().prepareStatement(sql1)){
                    stmtUpdate.setLong(1,pantallaTextKio.getId());
                    stmtUpdate.setString(2,pantallaTextKio.getText());
                    stmtUpdate.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public Long insert(PantallaTextKio pantallaTextKio) {
        Long id = null;
        String sql1 = "INSERT INTO pantallas_text(text_pantalla) VALUES(?)";
        try (PreparedStatement stmtUpdate = getConnection().prepareStatement(sql1)){
            stmtUpdate.setString(1,pantallaTextKio.getText());
            stmtUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT id_pantalla FROM pantallas_text WHERE text_pantalla =?")){
            stmt.setString(1,pantallaTextKio.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                id = rs.getLong("id_pantalla");
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public void eliminar(Long id) {
    }

    @Override
    public PantallaTextKio porNumProducto(String numProd) {
        return null;
    }
}
