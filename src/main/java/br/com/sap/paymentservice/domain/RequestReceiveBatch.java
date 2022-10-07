package br.com.sap.paymentservice.domain;

import java.util.List;

public class RequestReceiveBatch {
    private List<CompleteBatchInfo> lotes;

    public List<CompleteBatchInfo> getLotes() {
        return lotes;
    }

    public RequestReceiveBatch setLotes(List<CompleteBatchInfo> lotes) {
        this.lotes = lotes;
        return this;
    }
}
