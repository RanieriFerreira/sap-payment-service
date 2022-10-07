package br.com.sap.paymentservice.domain;

import java.util.List;

public class RequestConfirmPayment {
    private List<BatchInfo> lotes;

    public List<BatchInfo> getLotes() {
        return lotes;
    }

    public RequestConfirmPayment setLotes(List<BatchInfo> lotes) {
        this.lotes = lotes;
        return this;
    }
}
