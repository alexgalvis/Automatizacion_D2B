package co.com.bancolombia.kioscos.automatizacion.repository.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabffctas;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;
import co.com.bancolombia.kioscos.automatizacion.utils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CabffctasImpl implements IQuestion<Cabffctas>{
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }

    @Override
    public Cabffctas ask(String t) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Cabffctas> listar(String numCardTj) {
        ArrayList<Cabffctas> listCabffctas = new ArrayList<>();
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT CAESTADO, CANROTRJ, CANROCTA,CANROCLV FROM CABLIBRAMD.CABFFCTAS WHERE CANROTRJ = ?")){
            stmt.setString(1,numCardTj);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    Cabffctas cabffctas = new Cabffctas(numCardTj);
                    cabffctas.setCtas(rs.getString("CANROCTA"));
                    cabffctas.setEstado(rs.getString("CAESTADO"));
                    cabffctas.setNumCardTj(rs.getString("CANROTRJ"));
                    cabffctas.setClvcta(rs.getString("CANROCLV"));
                    listCabffctas.add(cabffctas);
                }
                if (rs.next()){
                    throw new RuntimeException("No se encontraron cuentas asociadas a la tarjeta");
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listCabffctas;
    }

    @Override
    public void update(Cabffctas t) {
    }

    @Override
    public void delete(String numCardTj) throws SQLException {
        try(Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement
                ("DELETE FROM CABLIBRAMD.CABFFCTAS WHERE CANROTRJ = ?")){
            stmt.setString(1,numCardTj);
            int registros = stmt.executeUpdate();
            System.out.println("Regitros eliminados: CABFFCTAS " + registros);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
