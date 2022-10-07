package br.com.sap.paymentservice.domain;

import java.util.List;

public class ResponseCheckProcessing {
    private Float statusRecebimento;
    private List<BatchIdStatus> lotes;

    public Float getStatusRecebimento() {
        return statusRecebimento;
    }

    public ResponseCheckProcessing setStatusRecebimento(Float statusRecebimento) {
        this.statusRecebimento = statusRecebimento;
        return this;
    }

    public List<BatchIdStatus> getLotes() {
        return lotes;
    }

    public ResponseCheckProcessing setLotes(List<BatchIdStatus> lotes) {
        this.lotes = lotes;
        return this;
    }
}
