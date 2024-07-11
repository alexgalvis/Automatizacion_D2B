package co.com.bancolombia.kioscos.automatizacion.repository.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffmdmae;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatffmdmaeImpl implements IQuestion<Matffmdmae>{
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }

    @Override
    public Matffmdmae ask(String t) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Matffmdmae> listar(String t) {
        return null;
    }

    @Override
    public void update(Matffmdmae matffmdmae) {

    }

    @Override
    public void delete(String numCard) throws SQLException{
        try(Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement
                ("DELETE FROM MATLIBRAMD.MATFFMDMAE WHERE NROTRJ = ?")){
            stmt.setString(1,numCard);
            int registros = stmt.executeUpdate();
            System.out.println("Regitros eliminados: MATFFMDMAE " + registros);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
