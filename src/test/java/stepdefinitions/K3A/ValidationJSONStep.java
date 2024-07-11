package stepdefinitions.K3A;

import co.com.bancolombia.kioscos.automatizacion.modelos.packageK3A.Endpoints;
import co.com.bancolombia.kioscos.automatizacion.modelos.packageK3A.Kiosk;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidationJSONStep {
    private final String rutaReference = "C:\\Users\\Alex Duban Galvis\\Documents\\CELULA KIOSCO\\AUTOMATIZACIONES\\SERENITY BBD - ISERIES\\serenity-cucumber-page-objects-starter-master\\K3ARef\\";
    private final String rutaConfig = "C:\\Users\\Alex Duban Galvis\\Documents\\CELULA KIOSCO\\CARGUE DE PAQUETES\\K3A\\CONFIG\\";
    private Kiosk kioskFin;
    private Endpoints endpointFin;
    private Endpoints endpointRef;

    @Given("tengo los siguientes archivos JSON:")
    public void tengoLosSiguientesArchivosJSON(List<String> archivos) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.kioskFin = objectMapper.readValue(new File(rutaConfig +  archivos.get(0)), Kiosk.class);
            this.endpointFin = objectMapper.readValue(new File(rutaConfig +  archivos.get(1)), Endpoints.class);
            this.endpointRef = objectMapper.readValue(new File(rutaReference +  archivos.get(1)), Endpoints.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @When("analizo los archivos JSON")
    public void analizoLosArchivosJSON() {
        // No se necesita nada aquí, ya que los archivos se analizarán en el paso Then
    }
    @Then("la estructura de cada JSON debe ser válida")
    public void validoLosCamposDeLosArchivosJSON() {
        Kiosk kiosk = new Kiosk();
        assertEquals(kioskFin.getAdviserCode(),kiosk.getAdviserCode(),"adviserCode");
        assertEquals(kioskFin.getOfficeCode(),kiosk.getOfficeCode(),"officeCode");
        assertEquals(kioskFin.getOracleAccess(),kiosk.getOracleAccess(),"oracleAccess");
        assertEquals(kioskFin.getOraclePasword(),kiosk.getOraclePasword(),"oraclePasword");
        assertEquals(kioskFin.getOracleUsername(),kiosk.getOracleUsername(),"oracleUsername");
        System.out.println(kioskFin.toString());

        // Validacion de endpoints
        assertEquals(endpointRef.getServices("AppValidator").getAddress(),endpointFin.getServices("AppValidator").getAddress(),"AppValidator");
        assertEquals(endpointRef.getServices("Authentication").getAddress(),endpointFin.getServices("Authentication").getAddress(),"Authentication");
        assertEquals(endpointRef.getServices("BankStatement").getAddress(),endpointFin.getServices("BankStatement").getAddress(),"BankStatement");
        assertEquals(endpointRef.getServices("KtcContingency").getAddress(),endpointFin.getServices("KtcContingency").getAddress(),"KtcContingency");
        assertEquals(endpointRef.getServices("KtcMain").getAddress(),endpointFin.getServices("KtcMain").getAddress(),"KtcMain");

        // Validacion de clientsrecret
        assertEquals(endpointRef.getServices("retrievelastexpedition").getClientsecret(),endpointFin.getServices("retrievelastexpedition").getClientsecret(),"retrievelastexpedition");

    }


}
