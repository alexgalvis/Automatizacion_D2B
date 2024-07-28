package co.com.bancolombia.kioscos.automatizacion.modelos.BD;

public class PantallaTextKio {
    private Long id;
    private String text;
    private double tolerancia;
    private int id_flujo;

    public PantallaTextKio(Long id) {
        this.id = id;
    }

    public PantallaTextKio(String text, double tolerancia, int id_flujo) {
        this.text = text;
        this.tolerancia = tolerancia;
        this.id_flujo = id_flujo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(double tolerancia) {
        this.tolerancia = tolerancia;
    }

    public int getId_flujo() {
        return id_flujo;
    }

    public void setId_flujo(int id_flujo) {
        this.id_flujo = id_flujo;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------------\n" +
                "\t\tText\t\t\t\t\tID\t\tTol\t\tIdFlujo\n"+
                "---------------------------------------------------------------------------"+
                "\t\t" + text + "\t\t\t\t\t\t\t" + id + "\t\t" + tolerancia + "\t\t" + id_flujo + "\n"+
                "---------------------------------------------------------------------------";
    }
}
