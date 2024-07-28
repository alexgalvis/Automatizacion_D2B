package co.com.bancolombia.kioscos.automatizacion.modelos.BD;

public class CasoPruebaKio {
    private int idCaso;
    private String pantallas;
    private String text;
    private String tipo_trn;

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    public String getPantallas() {
        return pantallas;
    }

    public void setPantallas(String pantallas) {
        this.pantallas = pantallas;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTipo_trn() {
        return tipo_trn;
    }

    public void setTipo_trn(String tipo_trn) {
        this.tipo_trn = tipo_trn;
    }
}
