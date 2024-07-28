package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import java.util.ArrayList;

public interface Repositorio<T>{
    ArrayList<T> listarPorCategoria(Long idFlujo);
    T porId(Long id);
    //void guardar(T t);
    Long insert(T t);

    //void eliminar(Long id);
    //T porNumProducto(String numProd);
}
