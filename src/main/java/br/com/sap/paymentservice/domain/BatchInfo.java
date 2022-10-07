package br.com.sap.paymentservice.domain;

public class BatchInfo {

    private Float noLote;
    private Float noPagamento;
    private Float valorPagamento;
    private Float status;

    public Float getNoLote() {
        return noLote;
    }

    public BatchInfo setNoLote(Float noLote) {
        this.noLote = noLote;
        return this;
    }

    public Float getNoPagamento() {
        return noPagamento;
    }

    public BatchInfo setNoPagamento(Float noPagamento) {
        this.noPagamento = noPagamento;
        return this;
    }

    public Float getValorPagamento() {
        return valorPagamento;
    }

    public BatchInfo setValorPagamento(Float valorPagamento) {
        this.valorPagamento = valorPagamento;
        return this;
    }

    public Float getStatus() {
        return status;
    }

    public BatchInfo setStatus(Float status) {
        this.status = status;
        return this;
    }
}
