package br.com.sap.paymentservice.domain;

import java.util.List;

public class RequestCheckProcessing {
    private List<BathId> lote;

    public List<BathId> getLote() {
        return lote;
    }

    public RequestCheckProcessing setLote(List<BathId> lote) {
        this.lote = lote;
        return this;
    }
}
