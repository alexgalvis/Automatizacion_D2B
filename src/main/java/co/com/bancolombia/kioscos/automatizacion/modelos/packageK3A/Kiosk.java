package co.com.bancolombia.kioscos.automatizacion.modelos.packageK3A;

import co.com.bancolombia.kioscos.automatizacion.utils.AppProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Kiosk {
    private  final String oracleAccess = AppProperties.getOracleAccess();
    private final String oracleUsername = AppProperties.getOracleUsername();
    private final String oraclePasword = AppProperties.getOraclePasword();
    private final String officeCode = AppProperties.getOfficeCode();
    private final String adviserCode = AppProperties.getAdviserCode();


    public String getOracleAccess() {
        return oracleAccess;
    }


    public String getOracleUsername() {
        return oracleUsername;
    }

    public String getOraclePasword() {
        return oraclePasword;
    }


    public String getOfficeCode() {
        return officeCode;
    }

    public String getAdviserCode() {
        return adviserCode;
    }

    @Override
    public String toString() {
        return "Kiosk:\n" +
                "oracleAccess='" + oracleAccess + "\n" +
                "oracleUsername='" + oracleUsername + "\n" +
                "oraclePasword='" + oraclePasword + "\n" +
                "officeCode='" + officeCode + "\n" +
                "adviserCode='" + adviserCode;
    }
}
