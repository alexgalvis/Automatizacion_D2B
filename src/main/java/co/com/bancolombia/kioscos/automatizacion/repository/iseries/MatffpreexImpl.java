package co.com.bancolombia.kioscos.automatizacion.repository.iseries;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffpreex;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatffpreexImpl implements IQuestion<Matffpreex>{
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }


    @Override
    public Matffpreex ask(String numCard) {
        Matffpreex matffpreex = new Matffpreex(numCard);
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT CDGTRJ, OFICINA, CLSTRJ, NIT FROM MATLIBRAMD.MATFFPREEX WHERE CDGTRJ = ?")){
            stmt.setString(1,numCard);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    matffpreex.setNit(rs.getString("NIT"));
                    matffpreex.setClase(rs.getString("CLSTRJ"));
                    matffpreex.setOffice(rs.getString("OFICINA"));
                }else {
                    throw new RuntimeException("Tarjeta no existe en preexpedidas");
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return matffpreex;
    }

    @Override
    public ArrayList<Matffpreex> listar(String t) {
        return null;
    }

    @Override
    public void update(Matffpreex matffpreex) throws SQLException{
        try(Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement
                ("UPDATE MATLIBRAMD.MATFFPREEX SET NIT= '0',TIPONIT= '0',NOMBRE= '',APELLIDO1= '',DIRECCION= '',CIUDAD= ''," +
                        "TELEFONO= '0',NROCTA= '0',TPOCTA='',CDGPRM= '0',FECENT= '0',INDNOV= '0', OFICINA = '406' WHERE CDGTRJ = ?")){
            stmt.setString(1,matffpreex.getNumCard());
            int registros = stmt.executeUpdate();
            System.out.println("Regitros modificados en MATFFPREEX: " + registros);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String t) {

    }
}
