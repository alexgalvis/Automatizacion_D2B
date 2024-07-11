package co.com.bancolombia.kioscos.automatizacion.modelos.rest;

public class Data {
    private String customerDocumentType;
    private String customerDocumentId;
    private String queryType = "";

    public Data(String customerDocumentType, String customerDocumentId) {
        this.customerDocumentType = customerDocumentType;
        this.customerDocumentId = customerDocumentId;
    }

    public String getCustomerDocumentType() {
        return customerDocumentType;
    }

    public void setCustomerDocumentType(String customerDocumentType) {
        this.customerDocumentType = customerDocumentType;
    }

    public String getCustomerDocumentId() {
        return customerDocumentId;
    }

    public void setCustomerDocumentId(String customerDocumentId) {
        this.customerDocumentId = customerDocumentId;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
