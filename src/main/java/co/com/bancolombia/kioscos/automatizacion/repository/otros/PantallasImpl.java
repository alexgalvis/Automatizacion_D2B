package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.PantallaTextKio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;

import java.sql.*;
import java.util.ArrayList;

public class PantallasImpl implements Repositorio<PantallaTextKio> {
    private Connection getConnection() throws SQLException {
        return ConnectionBaseDatos.getInstance();
    }

    @Override
    public ArrayList<PantallaTextKio> listarPorCategoria(Long idFlujo) {
        ArrayList<PantallaTextKio> listScreen = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PANTALLAS WHERE ID_FLUJO = ?")){
            stmt.setLong(1,idFlujo);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    PantallaTextKio pantallaTextKio = getPantallaTextKio(rs);
                    listScreen.add(pantallaTextKio);
                }
                if (listScreen.size() == 0){
                    throw new RuntimeException("No se encontraron pantallas...");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listScreen;
    }

    @Override
    public PantallaTextKio porId(Long id) {
        PantallaTextKio pantallaTextKio = new PantallaTextKio(id);
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM pantallas WHERE id_pantalla =?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    pantallaTextKio = getPantallaTextKio(rs);
                }else {pantallaTextKio = null;}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pantallaTextKio;
    }

    @Override
    public Long insert(PantallaTextKio pantallaTextKio) {
        Long id = null;
        try (PreparedStatement stmtUpdate = getConnection().
                prepareStatement("INSERT INTO pantallas(text,tolerancia,id_flujo) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            stmtUpdate.setString(1,pantallaTextKio.getText());
            stmtUpdate.setDouble(2,pantallaTextKio.getTolerancia());
            stmtUpdate.setLong(3,pantallaTextKio.getId_flujo());
            stmtUpdate.executeUpdate();
            try (ResultSet generatedKeys = stmtUpdate.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private static PantallaTextKio getPantallaTextKio(ResultSet rs) throws SQLException {
        PantallaTextKio pantallaTextKio = new PantallaTextKio(rs.getLong("id_pantalla"));
        pantallaTextKio.setText(rs.getString("text"));
        pantallaTextKio.setId_flujo(rs.getInt("id_flujo"));
        pantallaTextKio.setTolerancia(rs.getDouble("tolerancia"));
        return pantallaTextKio;
    }
}
