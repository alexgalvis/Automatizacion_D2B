package co.com.bancolombia.kioscos.automatizacion.repository.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffestcl;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatffestclImpl implements IQuestion<Matffestcl> {
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }



    @Override
    public Matffestcl ask(String nit) throws SQLException {
        Matffestcl matffestcl = new Matffestcl(nit);
        //String query = "SELECT ECFECHA FROM MATLIBRAMD.MATFFESTCL WHERE ECNROID = ?";
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT ECFECHA FROM MATLIBRAMD.MATFFESTCL WHERE ECNROID = ?")){
            stmt.setString(1,nit);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    //matffestcl.setLastUpdate(rs.getDate("ECFECHA"));
                    //System.out.println(matffestcl.getLastUpdate());
                    String fec = rs.getString(1);
                    System.out.println(fec);
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return matffestcl;
    }

    @Override
    public ArrayList<Matffestcl> listar(String t) {
        return null;
    }

    @Override
    public void update(Matffestcl matffestcl) {
        try (Connection connn = getConnection(); PreparedStatement stmt = connn.prepareStatement
                ("UPDATE MATLIBRAMD.MATFFESTCL SET ECFECHA = ? WHERE ECNROID = ?")){
            stmt.setDate(1,matffestcl.getLastUpdate());
            stmt.setString(2,matffestcl.getNit());
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String t) {

    }
}
