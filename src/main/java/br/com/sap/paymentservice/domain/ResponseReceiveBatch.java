package br.com.sap.paymentservice.domain;

import java.util.List;

public class ResponseReceiveBatch {
    private List<BatchInfo> lotes;

    public List<BatchInfo> getLotes() {
        return lotes;
    }

    public ResponseReceiveBatch setLotes(List<BatchInfo> lotes) {
        this.lotes = lotes;
        return this;
    }
}
