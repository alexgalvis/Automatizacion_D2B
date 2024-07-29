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
    public void Update(PantallaTextKio pantallaTextKio) {
        try(PreparedStatement stmt = getConnection().
                prepareStatement("UPDATE PANTALLAS SET TEXT = ?, TOLERANCIA = ?, ID_FLUJO = ? WHERE ID_PANTALLA = ?")){
            stmt.setString(1,pantallaTextKio.getText());
            stmt.setDouble(2,pantallaTextKio.getTolerancia());
            stmt.setLong(3,pantallaTextKio.getId_flujo());
            stmt.setLong(4,pantallaTextKio.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public void eliminar(Long id) {
        try(Connection conn = getConnection();PreparedStatement stmt = conn.
                prepareStatement("DELETE FROM PANTALLAS WHERE ID_PANTALLA = ?")) {
            stmt.setLong(1,id);
            int registros = stmt.executeUpdate();
            System.out.println("\nPantallas eliminadas: " + registros);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PantallaTextKio getPantallaTextKio(ResultSet rs) throws SQLException {
        PantallaTextKio pantallaTextKio = new PantallaTextKio(rs.getLong("id_pantalla"));
        pantallaTextKio.setText(rs.getString("text"));
        pantallaTextKio.setId_flujo(rs.getInt("id_flujo"));
        pantallaTextKio.setTolerancia(rs.getDouble("tolerancia"));
        return pantallaTextKio;
    }
}
