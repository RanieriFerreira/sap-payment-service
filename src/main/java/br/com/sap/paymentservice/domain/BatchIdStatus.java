package br.com.sap.paymentservice.domain;

public class BatchIdStatus {
    private String noLote;
    private Float status;

    public String getNoLote() {
        return noLote;
    }

    public BatchIdStatus setNoLote(String noLote) {
        this.noLote = noLote;
        return this;
    }

    public Float getStatus() {
        return status;
    }

    public BatchIdStatus setStatus(Float status) {
        this.status = status;
        return this;
    }
}
