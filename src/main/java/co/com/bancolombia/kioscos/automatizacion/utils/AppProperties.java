package co.com.bancolombia.kioscos.automatizacion.utils;

import dataProviders.ConfigFileReader;

public class AppProperties {

    private AppProperties(){}

    static ConfigFileReader reader = new ConfigFileReader("configs/config.properties");


    //Connections
    public static String getStrConexionIseries(){
        return reader.getPropertyByKey("strConexionIs");
    }

    public static String getUserIseries(){
        return reader.getPropertyByKey("userIs");
    }

    public static String getPasswordIseries(){
        return reader.getPropertyByKey("passwordIs");
    }

    public static String getStrConexionAuthentic(){
        return reader.getPropertyByKey("strConexionVa");
    }

    public static String getUserAuthentic(){
        return reader.getPropertyByKey("userVa");
    }

    public static String getPasswordAuthentic(){
        return reader.getPropertyByKey("passwordVa");
    }

    public static String getOracleAccess(){ return reader.getPropertyByKey("oracleAccess");}
    public static String getOracleUsername(){return reader.getPropertyByKey("oracleUsername");}
    public static String getOraclePasword(){return reader.getPropertyByKey("oraclePasword");}
    public static String getOfficeCode(){return reader.getPropertyByKey("officeCode");}
    public static String getAdviserCode(){return reader.getPropertyByKey("adviserCode");}



}
