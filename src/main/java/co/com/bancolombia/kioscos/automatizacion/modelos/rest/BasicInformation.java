package co.com.bancolombia.kioscos.automatizacion.modelos.rest;

public class BasicInformation {
    private Data data;

    public BasicInformation(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
