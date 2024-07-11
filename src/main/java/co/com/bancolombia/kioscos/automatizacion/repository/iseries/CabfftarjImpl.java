package co.com.bancolombia.kioscos.automatizacion.repository.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabfftarj;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionIseriesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CabfftarjImpl implements IQuestion<Cabfftarj>{
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionIseriesBD.getInstance();
        //return ConnectionBaseDatos.getInstance();  // Base de datos local simulada
    }


    @Override
    public Cabfftarj ask(String numCardTj) throws SQLException {
        Cabfftarj cabfftarj = new Cabfftarj(numCardTj);
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement
                    ("SELECT TJESTADO,TJNROTRJ,TJNRODOC,TJESTTARDB,TJFECEMIDB, ESPACIO1 FROM CABLIBRAMD.CABFFTARJ WHERE TJNROTRJ = ?")){
            stmt.setString(1,numCardTj);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    cabfftarj.setCdEstado(rs.getString("TJESTADO"));
                    cabfftarj.setNit(rs.getString("TJNRODOC"));
                    cabfftarj.setTdEstado(rs.getString("TJESTTARDB"));
                    cabfftarj.setFechaEmi(rs.getString("TJFECEMIDB"));
                    cabfftarj.setEspacio1(rs.getString("ESPACIO1"));
                }else {
                    throw new RuntimeException("Tarjeta no existe en TARJ");
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cabfftarj;
    }

    @Override
    public ArrayList<Cabfftarj> listar(String t) {
        return null;
    }

    @Override
    public void update(Cabfftarj t) {

    }

    @Override
    public void delete(String numCardTj) throws SQLException{
        try(Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement
                ("DELETE FROM CABLIBRAMD.CABFFTARJ WHERE TJNROTRJ = ?")){
            stmt.setString(1,numCardTj);
            int registros = stmt.executeUpdate();
            System.out.println("Regitros eliminados: CABFFTARJ " + registros);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
