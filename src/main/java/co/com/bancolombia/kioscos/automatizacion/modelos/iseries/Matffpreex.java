package co.com.bancolombia.kioscos.automatizacion.modelos.iseries;

public class Matffpreex {
    private final String numCard;
    private  String clase;
    private  String office;
    private  String nit;

    public Matffpreex(String numCard) {
        this.numCard = numCard;
    }
    public void setNit(String nit){
        this.nit = nit;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getNumCard() {
        return numCard;
    }

    public String getClase() {
        return clase;
    }

    public String getOffice() {
        return office;
    }

    public String getNit() {
        return nit;
    }
}
