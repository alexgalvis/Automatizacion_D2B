package co.com.bancolombia.kioscos.automatizacion.modelos.iseries;

public class Cabffctas {
    private String estado;
    private String ctas;
    private String numCardTj;
    private String clvcta;

    public Cabffctas(String numCardTj) {
        this.numCardTj = numCardTj;
    }

    public String getEstado() {
        return estado;
    }

    public String getCtas() {
        return ctas;
    }

    public String getNumCardTj() {
        return numCardTj;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCtas(String ctas) {
        this.ctas = ctas;
    }

    public void setNumCardTj(String numCardTj) {
        this.numCardTj = numCardTj;
    }

    public String getClvcta() {
        return clvcta;
    }

    public void setClvcta(String clvcta) {
        this.clvcta = clvcta;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------\n"+
                estado+"\t|"+ctas+"\t\t|"+numCardTj+"\t\t|"+clvcta;
    }
}
