package co.com.bancolombia.kioscos.automatizacion.utils;

public enum ConstantApi {
    BASE_URI_MDM("https://gw-mdm-qa.apps.ambientesbc.lab"),
    BASE_URI_DEPOSITOS("https://gw-depositos-qa.apps.ambientesbc.lab"),
    BASE_URI_MOCK("https://7713fada-9283-463e-ae21-732dd2cbfd56.mock.pstmn.io"),
    BASE_URI_DEBITCARD("https://gw-medios-de-pago.apps.ocpqa.ambientesbc.lab"),
    BASE_PATH_MDM("/private-bancolombia/testing/v1/sales-services/customer-management"),
    BASE_PATH_ACCOUNT("/private-bancolombia/testing/v1/operations/product-specific/deposits/customers/accounts/"),
    CLIENT_ID_MDM("8c6ad2eac0e12943b5351835fc2ed356"),
    CLIENT_SECRET_MDM("4d4b72d2d89b13d423ee07916d9c15f7"),
    CLIENT_ID_ACCOUNT("59ebfaba492e5630bd496d0992568014"),
    CLIENT_SECRET_ACCOUNT("f1c702392dbbb8154f622d9d774ccb30"),
    MESSAGE_ID("6B29FC40-CA47-1067-B31D-00DD010662DA");

    private final String valor;

    ConstantApi(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
