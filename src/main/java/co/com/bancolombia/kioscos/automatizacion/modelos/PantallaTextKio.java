package co.com.bancolombia.kioscos.automatizacion.modelos;

public class PantallaTextKio {
    private Long id;
    private String text;

    public PantallaTextKio(String text) {
        this.text = text;
    }

    public PantallaTextKio(Long id) {
        this.id = id;
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
}
