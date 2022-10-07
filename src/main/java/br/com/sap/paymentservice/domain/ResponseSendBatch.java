package br.com.sap.paymentservice.domain;

import java.util.List;

public class ResponseSendBatch {
    private Float status;
    private List<CompleteBatchInfo> lotes;

    public Float getStatus() {
        return status;
    }

    public ResponseSendBatch setStatus(Float status) {
        this.status = status;
        return this;
    }

    public List<CompleteBatchInfo> getLotes() {
        return lotes;
    }

    public ResponseSendBatch setLotes(List<CompleteBatchInfo> lotes) {
        this.lotes = lotes;
        return this;
    }
}
