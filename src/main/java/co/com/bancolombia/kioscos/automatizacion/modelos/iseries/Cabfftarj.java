package co.com.bancolombia.kioscos.automatizacion.modelos.iseries;
public class Cabfftarj {
    private String cdEstado;
    private String numCardTj;
    private String nit;
    private String tdEstado;
    private String fechaEmi;
    private String espacio1;

    public Cabfftarj(String numCardTj) {
        this.numCardTj = numCardTj;
    }

    public String getCdEstado() {
        return cdEstado;
    }

    public String getNumCardTj() {
        return numCardTj;
    }

    public String getNit() {
        return nit;
    }

    public String getTdEstado() {
        return tdEstado;
    }

    public String getFechaEmi() {
        return fechaEmi;
    }

    public String getEspacio1() {
        return espacio1;
    }

    public void setCdEstado(String cdEstado) {
        this.cdEstado = cdEstado;
    }

    public void setNumCardTj(String numCardTj) {
        this.numCardTj = numCardTj;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setTdEstado(String tdEstado) {
        this.tdEstado = tdEstado;
    }

    public void setFechaEmi(String fechaEmi) {
        this.fechaEmi = fechaEmi;
    }

    public void setEspacio1(String espacio1) {
        this.espacio1 = espacio1;
    }

    @Override
    public String toString() {
        return "\n***********************   CABFFTARJ   ******************************************\n"+
                "CDEstado\tNumeroTarjeta\tNit\t\t\tTDEstado\tFechaEmi\t\tEspacio1\n"+
                "-----------------------------------------------------------------------------------------\n" +
                cdEstado+"\t       |"+numCardTj+"\t\t|"+nit+"\t|"+tdEstado+"\t\t\t|"+fechaEmi+"\t\t|"+espacio1 +"\n"+
                "-----------------------------------------------------------------------------------------";
    }
}
