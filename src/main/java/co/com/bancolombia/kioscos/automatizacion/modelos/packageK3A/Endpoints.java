package co.com.bancolombia.kioscos.automatizacion.modelos.packageK3A;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Endpoints {
    private Map<String,Services> listEndpoints = new HashMap<>();
    @JsonAnySetter
    public void setService(String nombre, Services services){
        listEndpoints.put(nombre,services);
    }
    public Services getServices(String nombre){
        return listEndpoints.get(nombre);
    }
}
