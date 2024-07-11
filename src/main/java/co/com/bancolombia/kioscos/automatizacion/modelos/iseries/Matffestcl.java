package co.com.bancolombia.kioscos.automatizacion.modelos.iseries;

public class Matffestcl {
    private java.sql.Date lastUpdate;
    private String nit;

    public Matffestcl(String nit) {
        this.nit = nit;
    }

    public Matffestcl(java.sql.Date lastUpdate, String nit) {
        this.lastUpdate = lastUpdate;
        this.nit = nit;
    }

    public void setLastUpdate(java.sql.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public java.sql.Date getLastUpdate() {
        return lastUpdate;
    }

    public String getNit() {
        return nit;
    }
}
