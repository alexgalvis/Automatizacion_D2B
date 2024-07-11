package co.com.bancolombia.kioscos.automatizacion.repository.iseries;

import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CabfftarjEnquiry implements IQuestion<ArrayList<String>> {
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }

    @Override
    public ArrayList<String> ask(String numTarjeta){
        ArrayList<String> array = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement
                ("SELECT TJESTADO,TJNROTRJ,TJNRODOC,TJESTTARDB,TJFECEMIDB, ESPACIO1 FROM CABLIBRAMD.CABFFTARJ WHERE TJNROTRJ = ?")){
            stmt.setString(1,numTarjeta);
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    array.add(rs.getString(1));
                    array.add(rs.getString(2));
                    array.add(rs.getString(3));
                    array.add(rs.getString(4));
                    array.add(rs.getString(5));
                    array.add(rs.getString(6));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return array;
    }

    @Override
    public ArrayList<ArrayList<String>> listar(String t) {
        return null;
    }

    @Override
    public void update(ArrayList<String> arrayList) {

    }

    @Override
    public void delete(String t) {

    }
}
