package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import java.util.List;

public interface Repositorio<T>{
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    Long insert(T t);

    void eliminar(Long id);
    T porNumProducto(String numProd);
}
