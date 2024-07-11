package co.com.bancolombia.kioscos.automatizacion.repository.iseries;
import java.sql.SQLException;
import java.util.ArrayList;


public interface IQuestion<ANSWER> {
    ANSWER ask(String t) throws SQLException;
    ArrayList<ANSWER> listar(String t);
    void update(ANSWER t) throws SQLException;
    void delete(String t) throws SQLException;

}
